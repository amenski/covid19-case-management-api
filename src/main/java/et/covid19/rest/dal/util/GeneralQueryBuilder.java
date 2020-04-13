package et.covid19.rest.dal.util;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import et.covid19.rest.annotations.EthLoggable;
import et.covid19.rest.dal.model.ConstantEnum;
import et.covid19.rest.dal.model.PuiInfo;

@Component
public class GeneralQueryBuilder {

	@PersistenceContext
	private EntityManager em;
	
	@EthLoggable
	public List<PuiInfo> buildCaseSearchCriteria(Integer confirmedResult, Integer status, String region, String recentTravelTo) {
		List<PuiInfo> puiList = new ArrayList<>();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<PuiInfo> query = cb.createQuery(PuiInfo.class);
		Root<PuiInfo> rootPui = query.from(PuiInfo.class);
		
		List<Predicate> predicateList = new ArrayList<>();
		if(confirmedResult != null) {
			predicateList.add(predicateWithConstants(rootPui, cb, "confirmedResult", confirmedResult));
		}
		if(status != null) {
			predicateList.add(predicateWithConstants(rootPui, cb, "status", status));
		}
		if(!StringUtils.isBlank(region)) {
			Predicate p = cb.equal(rootPui.get("region"), region);
			predicateList.add(p);
		}
		if(!StringUtils.isBlank(recentTravelTo)) {
			Predicate p = cb.equal(rootPui.get("recentTravelTo"), recentTravelTo);
			predicateList.add(p);
		}
		
		if(predicateList.isEmpty())
			return puiList;
		
		Predicate finalPredicate = cb.and(predicateList.toArray(new Predicate [] {}));
		puiList = em.createQuery(query.where(finalPredicate)).getResultList();
		return puiList;
	}
	
	private Predicate predicateWithConstants(Root<PuiInfo> root, CriteriaBuilder cb, String fieldName, Integer enumCode) {
		Join<PuiInfo, ConstantEnum> enumJoin = root.join(fieldName);
		return cb.equal(enumJoin.get("enumCode"), enumCode);
	}
}
