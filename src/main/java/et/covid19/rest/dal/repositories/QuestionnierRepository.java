package et.covid19.rest.dal.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import et.covid19.rest.dal.model.Questionier;

@Repository
public interface QuestionnierRepository extends JpaRepository<Questionier, Integer> {

	List<Questionier> findByCategory(String type);
	
	@Query("select q from Questionier q where q.id in :ids")
	List<Questionier> findByIds(Set<Integer> ids);
}
