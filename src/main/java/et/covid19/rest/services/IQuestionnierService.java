package et.covid19.rest.services;

import et.covid19.rest.swagger.model.ModelQuestionnier;
import et.covid19.rest.swagger.model.RequestSaveQuestionnier;
import et.covid19.rest.util.exception.EthException;

public interface IQuestionnierService {

	public boolean registerQuestionnier(RequestSaveQuestionnier question) throws EthException;
	
	public ModelQuestionnier getQuestionnier(Integer id) throws EthException;
}
