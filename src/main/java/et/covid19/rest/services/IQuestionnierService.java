package et.covid19.rest.services;

import et.covid19.rest.swagger.model.ModelCase;
import et.covid19.rest.swagger.model.RequestSaveQuestionnier;
import et.covid19.rest.util.exception.EthException;

public interface IQuestionnierService {

	public boolean registerQuestionnier(RequestSaveQuestionnier question) throws EthException;
	
	public ModelCase getQuestionnier(Integer id) throws EthException;
}
