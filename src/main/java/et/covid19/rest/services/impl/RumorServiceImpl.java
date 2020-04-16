package et.covid19.rest.services.impl;

import java.time.OffsetDateTime;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.google.common.collect.ImmutableSet;

import et.covid19.rest.annotations.EthLoggable;
import et.covid19.rest.dal.model.ConstantEnum;
import et.covid19.rest.dal.model.RumorReport;
import et.covid19.rest.dal.repositories.RumorReportRepository;
import et.covid19.rest.services.IRumorService;
import et.covid19.rest.swagger.model.ModelRumor;
import et.covid19.rest.swagger.model.ModelRumorList;
import et.covid19.rest.swagger.model.RequestSaveRumor;
import et.covid19.rest.util.EthConstants;
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
            OffsetDateTime timeNow = OffsetDateTime.now();
            RumorReport report = RumorReportMapper.INSTANCE.modelToEntity(rumor);
            if(StringUtils.isBlank(report.getAddress())) 
                throw EthExceptionEnums.ADDRESS_EMPTY_EXCEPTION.get();
            
            report.setStatus(new ConstantEnum(EthConstants.CONST_RUMOR_PENDING));
            report.setReportDate(timeNow);
            report.setModifiedDate(timeNow);
            rumorRepository.save(report);
            return true;
        } catch(ConstraintViolationException | DataIntegrityViolationException e) {
            throw EthExceptionEnums.VALIDATION_EXCEPTION.get();
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    @EthLoggable
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

    @Override
    @EthLoggable
    public ModelRumor getRumorReport(Integer id) throws EthException {
        try{
            RumorReport report = rumorRepository.findById(id).orElseThrow(EthExceptionEnums.RUMOR_DATA_NOT_FOUND);
            ModelRumor model = RumorReportMapper.INSTANCE.entityToModel(report);
            return model;
        } catch(ConstraintViolationException | DataIntegrityViolationException e) {
            throw EthExceptionEnums.VALIDATION_EXCEPTION.get();
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    @EthLoggable
    public boolean updateRumorReportStatus(Integer id, Integer statusId) throws EthException {
        try{
            if(id != null && Integer.signum(id) == 1) {
                RumorReport report  = rumorRepository.findById(id).orElseThrow(EthExceptionEnums.RUMOR_DATA_NOT_FOUND);
                validateInputEnumById(EthConstants.RUMOR_REPORT_STATUS, ImmutableSet.of(statusId));
                report.setStatus(new ConstantEnum(statusId));
                report.setModifiedby(getCurrentLoggedInUserId());
                report.setModifiedDate(OffsetDateTime.now());
                
                rumorRepository.save(report);
            }
            return true;
        } catch(ConstraintViolationException | DataIntegrityViolationException e) {
            throw EthExceptionEnums.VALIDATION_EXCEPTION.get();
        } catch (Exception ex) {
            throw ex;
        }
    }

}
