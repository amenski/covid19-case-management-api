package et.covid19.rest.dal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import et.covid19.rest.dal.model.PuiInfo;

@Repository
public interface PuiInfoRepository extends JpaRepository<PuiInfo, Integer> {

	PuiInfo findByCaseCode(String uuid);
}
