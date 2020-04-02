package et.covid19.rest.dal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import et.covid19.rest.dal.model.PuiInfo;

@Repository
public interface PuiInfoRepository extends JpaRepository<PuiInfo, Integer> {

	PuiInfo findByCaseCode(String uuid);

	@Query("select pui from PuiInfo pui where pui.caseCode in (:codeList)")
	List<PuiInfo> findAllByCaseCode(List<String> codeList);
}
