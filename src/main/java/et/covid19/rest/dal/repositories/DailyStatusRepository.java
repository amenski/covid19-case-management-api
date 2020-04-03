package et.covid19.rest.dal.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import et.covid19.rest.dal.model.CaseStat;

@Repository
public interface DailyStatusRepository extends JpaRepository<CaseStat, Integer> {
	
	List<CaseStat> findByReportDate(LocalDate date);
}
