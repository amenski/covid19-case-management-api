package et.covid19.rest.dal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import et.covid19.rest.dal.model.ContactTracing;

@Repository
public interface ContactTracingRepository extends JpaRepository<ContactTracing, String> {
	
	ContactTracing findByParentCaseCode(String code);
}
