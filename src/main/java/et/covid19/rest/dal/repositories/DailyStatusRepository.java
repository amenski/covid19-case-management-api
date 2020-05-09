package et.covid19.rest.dal.repositories;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import et.covid19.rest.dal.model.CaseStat;

@Repository
public interface DailyStatusRepository extends JpaRepository<CaseStat, Integer> {
	
	CaseStat findByReportDate(LocalDate date);
	
	@Query(nativeQuery = true, value = "SELECT * FROM case_stat ORDER BY report_date DESC LIMIT 1")
	CaseStat findLastUpdated();
}
