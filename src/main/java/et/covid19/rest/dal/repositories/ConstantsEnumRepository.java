package et.covid19.rest.dal.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import et.covid19.rest.dal.model.ConstantEnum;

@Repository
public interface ConstantsEnumRepository extends JpaRepository<ConstantEnum, Integer> {

	List<ConstantEnum> findByEnumType(String type);
	
	Optional<ConstantEnum> findByEnumName(String name);
}
