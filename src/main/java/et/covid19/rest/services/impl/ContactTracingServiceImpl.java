package et.covid19.rest.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import et.covid19.rest.annotations.EthLoggable;
import et.covid19.rest.dal.model.ContactTracing;
import et.covid19.rest.dal.repositories.ContactTracingRepository;
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
			 * 1. findAll the parent:child and get the row with `code` == `parentCode`
			 * 2. Get the parent
			 * 3. Create(populate) TreeNode from its children and return it.
			 * 4. Create(populate) TreeNode from the parent
			 * 5. build the overall tree
			 *  
			 */
			ContactTracing pcase = null;
			//1
			List<ContactTracing> pcases = contactTracingRepository.findAll();
			List<TreeNode<ContactTracing>> listOfCt = new ArrayList<>(100); 
			for(ContactTracing single : pcases) {
			    //2
				if(code.equals(single.getParentCaseCode())){
					pcase = single;
				}
				//3
				listOfCt.add(populateChildren(single));
			}
			//4
			TreeNode<ContactTracing> parentNode = populateChildren(pcase);
			//5
			return buildTree(parentNode, listOfCt);
		}catch (Exception ex) {
			throw ex;
		}
	}
	
	private TreeNode<ContactTracing> populateChildren(ContactTracing ct) {
		if(Objects.isNull(ct))
			return null;
		
		TreeNode<ContactTracing> node = new TreeNode<>(ct);
		ct.getChildren().stream().forEach(child -> {
			node.getChildren().add(new TreeNode<ContactTracing>(child));
		});
		return node;
	}
	//TODO how to add additional fields from PUI_INFO?
	@EthLoggable
	private String buildTree(TreeNode<ContactTracing> parent, List<TreeNode<ContactTracing>> list) {
		String json = null;
		try {
			GenericTree<ContactTracing> genericTree = new GenericTree<ContactTracing>().buildTree(parent, list);
			//remove extra children block from parent.data
			genericTree.getRoot().getData().getChildren().clear(); 
			json = genericTree.getJSON();
		} catch (Exception ex) {
		}
		return json;
	}

	// build tree for PuiInfo from ContactTracing tree
	// used this approach not to query the PuiInfo table for every parentCases and their corresponding children
	// the ContactTracing table holds only parent:child structure which will then be used here to build
	// the puiInfo tree which is the final output.
	private void constructPuiInfoFromTree(GenericTree<ContactTracing> tree) {
	    
	}
}
