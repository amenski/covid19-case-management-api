package et.covid19.rest.services.impl;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import et.covid19.rest.annotations.EthLoggable;
import et.covid19.rest.dal.model.CaseStat;
import et.covid19.rest.dal.repositories.DailyStatusRepository;
import et.covid19.rest.services.IDailyCaseStatus;
import et.covid19.rest.swagger.model.ModelDailyCaseStatus;
import et.covid19.rest.swagger.model.ModelDailyCaseStatusList;
import et.covid19.rest.util.GeneralUtils;
import et.covid19.rest.util.exception.EthException;
import et.covid19.rest.util.exception.EthExceptionEnums;
import et.covid19.rest.util.mappers.DailyStatusMapper;

@Service
public class DailyCaseStatusImpl implements IDailyCaseStatus {

	@Autowired
	private DailyStatusRepository dailyStatusRepository;
	
	@Override
	@EthLoggable
	public ModelDailyCaseStatus getDailyCaseStatus() throws EthException {
		try {
			CaseStat stat = dailyStatusRepository.findByReportDate(LocalDate.now())
					.stream().findFirst()
					.orElseThrow(EthExceptionEnums.DAILY_STAT_NOT_FOUND);
			
			return DailyStatusMapper.INSTANCE.entityToDto(stat);
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	@EthLoggable
	public ModelDailyCaseStatusList getAllDailyCaseStatus() throws EthException {
		try {
			List<CaseStat> stat = dailyStatusRepository.findAll();
			ModelDailyCaseStatusList dailies = new ModelDailyCaseStatusList();
			stat.stream().forEach(val -> {
				dailies.addListItem(DailyStatusMapper.INSTANCE.entityToDto(val));
			});
			return dailies;
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	@EthLoggable
	public boolean addDailyStatus(ModelDailyCaseStatus model) throws EthException {
		try {
			if(!GeneralUtils.validateCaseCount(Arrays.asList(
					model::getActiveCases,
					model::getCriticalCases,
					model::getNewCases,
					model::getNewDeaths,
					model::getRecovered,
					model::getTotalCases,
					model::getTotalDeaths))) 
				throw EthExceptionEnums.VALIDATION_EXCEPTION.get();
			
			dailyStatusRepository.save(DailyStatusMapper.INSTANCE.dtoToEntity(model));
			return true;
		} catch (Exception ex) {
			throw ex;
		}
	}

}
