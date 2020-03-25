package et.covid19.rest.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import et.covid19.rest.annotations.EthLoggable;
import et.covid19.rest.dal.model.PuiInfo;
import et.covid19.rest.dal.repositories.PuiInfoRepository;
import et.covid19.rest.services.ICaseService;
import et.covid19.rest.swagger.model.RequestSaveCase;
import et.covid19.rest.util.exception.EthException;
import et.covid19.rest.util.mappers.ModelCasePuiInfoMapper;

@Service
public class CaseServiceImpl implements ICaseService {
	
	@Autowired
	private PuiInfoRepository puiInfoRepository;
	
	@Override
	@EthLoggable
	public boolean registerNewCase(RequestSaveCase newCase) throws EthException {
		try{
			PuiInfo entity = ModelCasePuiInfoMapper.INSTANCE.modelCaseToPuiInfoMapper(newCase.getSchema());
			puiInfoRepository.save(entity);
			return true;
		} catch (Exception ex) {
			throw ex;
		}
	}

}
