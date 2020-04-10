package et.covid19.rest.services;

import et.covid19.rest.swagger.model.ModelQuestionnaire;
import et.covid19.rest.swagger.model.ModelQuestionnaireList;
import et.covid19.rest.swagger.model.RequestSaveQuestionnaire;
import et.covid19.rest.util.exception.EthException;

public interface IQuestionnierService {

	public boolean registerQuestionnier(RequestSaveQuestionnaire question) throws EthException;
	
	public ModelQuestionnaire getQuestionnaire(Integer id) throws EthException;
	
	public ModelQuestionnaireList getAllQuestionnaire() throws EthException;
}
