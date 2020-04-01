package et.covid19.rest.dal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import et.covid19.rest.dal.model.PuiFollowUp;

@Repository
public interface CaseFollowUpRepository extends JpaRepository<PuiFollowUp, Integer> {
	
	@Query("select fl from PuiFollowUp fl where puiInfo.caseCode = :caseCode")
	PuiFollowUp findWithPuiCaseCode(String caseCode);
}
