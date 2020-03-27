package et.covid19.rest.controllers;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import et.covid19.rest.config.AbstractController;
import et.covid19.rest.swagger.api.CaseFollowUpApi;
import et.covid19.rest.swagger.model.RequestSaveFollowUp;
import et.covid19.rest.swagger.model.ResponseBase;
import io.swagger.annotations.ApiParam;

@RestController
public class CaseFollowUpController extends AbstractController implements CaseFollowUpApi {

	@Override
	public ResponseEntity<ResponseBase> compileFollowUpQuestionnier(
			@ApiParam(value = "",required=true) @PathVariable("code") UUID code,
			@ApiParam(value = ""  )  @Valid @RequestBody RequestSaveFollowUp body) 
	{
		// TODO Auto-generated method stub
		return CaseFollowUpApi.super.compileFollowUpQuestionnier(code, body);
	}
}
