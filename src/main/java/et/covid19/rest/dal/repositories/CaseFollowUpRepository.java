package et.covid19.rest.dal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import et.covid19.rest.dal.model.PuiFollowUp;

@Repository
public interface CaseFollowUpRepository extends JpaRepository<PuiFollowUp, Integer> {
}
