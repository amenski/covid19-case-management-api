package et.covid19.rest.services.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import et.covid19.rest.annotations.EthLoggable;
import et.covid19.rest.dal.model.ContactTracing;
import et.covid19.rest.dal.repositories.ContactTracingRepository;
import et.covid19.rest.dal.util.ContactTracingProjection;
import et.covid19.rest.services.IContactTracingService;
import et.covid19.rest.util.exception.EthException;
import et.covid19.rest.util.tree.GenericTree;
import et.covid19.rest.util.tree.TreeNode;

@Service
public class ContactTracingServiceImpl extends AbstractService implements IContactTracingService {

	@Autowired
	private ContactTracingRepository contactTracingRepository;
	
	@Override
	@EthLoggable
	public String traceContactByCode(String code) throws EthException {
		try{
			if(StringUtils.isBlank(code)) 
				return StringUtils.EMPTY;
			
			if(!contactTracingRepository.existsById(code))
				return StringUtils.EMPTY;
			
			/**
			 * ContactTracing table holds the format { parentCode:[childCode1#childCode2....] } 
			 * 
			 * Flow: 
			 * 1. findAll the parent:child
			 * 2. Get and process the parent with immediate children only
			 * 3. Add TreeNode to list with parent:child structure
			 * 4. build the overall tree
			 *  
			 */
			TreeNode<ContactTracingProjection> parentNode = null;
			//1
			List<ContactTracing> pcases = contactTracingRepository.findAll();
			List<TreeNode<ContactTracingProjection>> listOfCt = new ArrayList<>(100); 
			for(ContactTracing single : pcases) {
			    //2
				if(code.equals(single.getParentCaseCode())){
					parentNode = populateChildren(single);
					continue;
				}
				//3
				listOfCt.add(populateChildren(single));
			}
			//4
			return buildTree(parentNode, listOfCt);
		}catch (Exception ex) {
			throw ex;
		}
	}
	
	// for each parent with children, make a join to pui_info
	private TreeNode<ContactTracingProjection> populateChildren(ContactTracing ct) {
		if(Objects.isNull(ct))
			return null;
		
		Set<String> ids = new HashSet<>();
		ids.add(ct.getParentCaseCode());
		ids.addAll(ct.getChildren().stream().map(ContactTracing::getParentCaseCode).collect(Collectors.toSet()));
		
		List<ContactTracingProjection> parentChildProjections = contactTracingRepository.getContactTracingProjectionByCode(ids);
		Map<String, ContactTracingProjection> projectionMap = parentChildProjections.stream().collect(Collectors.toMap(ContactTracingProjection::getCode, Function.identity()));
		
		// get parent and child ctProjection once, and loop to populate
		TreeNode<ContactTracingProjection> node = new TreeNode<>(projectionMap.get(ct.getParentCaseCode()));
		ct.getChildren().stream().forEach(child -> {
			node.getChildren().add(new TreeNode<ContactTracingProjection>(projectionMap.get(child.getParentCaseCode())));
		});
		return node;
	}
	
	@EthLoggable
	private String buildTree(TreeNode<ContactTracingProjection> parent, List<TreeNode<ContactTracingProjection>> list) {
		String json = null;
		try {
			GenericTree<ContactTracingProjection> genericTree = new GenericTree<ContactTracingProjection>().buildTree(parent, list);
			json = genericTree.getJSON();
		} catch (Exception ex) {
		}
		return json;
	}
}
