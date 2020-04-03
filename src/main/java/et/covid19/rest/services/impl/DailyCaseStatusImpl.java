package et.covid19.rest.services.impl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import et.covid19.rest.dal.model.CaseStat;
import et.covid19.rest.dal.repositories.DailyStatusRepository;
import et.covid19.rest.services.IDailyCaseStatus;
import et.covid19.rest.swagger.model.ModelDailyCaseStatus;
import et.covid19.rest.util.exception.EthException;
import et.covid19.rest.util.exception.EthExceptionEnums;

@Service
public class DailyCaseStatusImpl implements IDailyCaseStatus {

	@Autowired
	private DailyStatusRepository dailyStatusRepository;
	
	@Override
	public ModelDailyCaseStatus getDailyCaseStatus() throws EthException {
		try {
			CaseStat stat = dailyStatusRepository.findByReportDate(LocalDate.now())
					.stream().findFirst()
					.orElseThrow(EthExceptionEnums.DAILY_STAT_NOT_FOUND);
			
			return new ModelDailyCaseStatus()
					.activeCases(stat.getActiveCases())
					.newCases(stat.getNewCases())
					.newDeaths(stat.getNewDeaths())
					.totalDeaths(stat.getTotalDeaths())
					.recovered(stat.getTotalRecovered())
					.criticalCases(stat.getSeriousCriticalCases())
					.totalCases(stat.getTotalCases());
		} catch (Exception ex) {
			throw ex;
		}
	}

}
