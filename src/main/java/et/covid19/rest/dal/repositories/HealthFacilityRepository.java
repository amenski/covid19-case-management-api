package et.covid19.rest.dal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import et.covid19.rest.dal.model.HealthFacility;

@Repository
public interface HealthFacilityRepository extends JpaRepository<HealthFacility, Integer> {
}
