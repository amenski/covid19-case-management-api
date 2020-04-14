package et.covid19.rest.services.impl;

import java.time.OffsetDateTime;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import et.covid19.rest.annotations.EthLoggable;
import et.covid19.rest.dal.model.RumorReport;
import et.covid19.rest.dal.repositories.RumorReportRepository;
import et.covid19.rest.services.IRumorService;
import et.covid19.rest.swagger.model.ModelRumor;
import et.covid19.rest.swagger.model.ModelRumorList;
import et.covid19.rest.swagger.model.RequestSaveRumor;
import et.covid19.rest.util.exception.EthException;
import et.covid19.rest.util.exception.EthExceptionEnums;
import et.covid19.rest.util.mappers.RumorReportMapper;

@Service
public class RumorServiceImpl extends AbstractService implements IRumorService {

    @Autowired
    private RumorReportRepository rumorRepository;
    
    @Override
    @EthLoggable
    public boolean registerRumor(RequestSaveRumor rumor) throws EthException {
        try{
            RumorReport report = RumorReportMapper.INSTANCE.modelToEntity(rumor);
            report.setReportDate(OffsetDateTime.now());
            rumorRepository.save(report);
            return true;
        } catch(ConstraintViolationException | DataIntegrityViolationException e) {
            throw EthExceptionEnums.VALIDATION_EXCEPTION.get();
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public ModelRumorList getAllRumorReports() throws EthException {
        try{
            ModelRumorList modelList = new ModelRumorList();
            List<RumorReport> reportList = rumorRepository.findAll(); //TODO paged list?
            for(RumorReport report : reportList) {
                ModelRumor model = RumorReportMapper.INSTANCE.entityToModel(report);
                modelList.addListItem(model);
            }    
            return modelList;
        } catch(ConstraintViolationException | DataIntegrityViolationException e) {
            throw EthExceptionEnums.VALIDATION_EXCEPTION.get();
        } catch (Exception ex) {
            throw ex;
        }
    }

}
