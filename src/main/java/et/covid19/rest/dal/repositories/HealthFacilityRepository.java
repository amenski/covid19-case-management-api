package et.covid19.rest.dal.repositories;

import et.covid19.rest.swagger.model.ModelHealthFacility;
import et.covid19.rest.swagger.model.RequestSaveFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthFacilityRepository extends JpaRepository<RequestSaveFacility, Long> {
}
