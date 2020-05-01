package et.covid19.rest.dal.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import et.covid19.rest.dal.model.ContactTracing;
import et.covid19.rest.dal.util.ContactTracingProjection;

@Repository
public interface ContactTracingRepository extends JpaRepository<ContactTracing, String> {
	
//	ContactTracing findByParentCaseCode(String code)
    
    @Query("select new et.covid19.rest.dal.util.ContactTracingProjection( "
            + " info.caseCode, info.firstName, info.confirmedResult.enumName)"
            + "from PuiInfo info where info.caseCode in :codes")
    List<ContactTracingProjection> getContactTracingProjectionByCode(Set<String> codes);
}
