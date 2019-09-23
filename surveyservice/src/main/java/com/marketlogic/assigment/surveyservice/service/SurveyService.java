package com.marketlogic.assigment.surveyservice.service;

import com.marketlogic.assigment.surveyservice.entity.SurveyAggregateEntity;
import com.marketlogic.assigment.surveyservice.exception.ResourceNotFoundException;
import com.marketlogic.assigment.surveyservice.model.SurveySummaryModel;

public interface SurveyService {
	
	public SurveyAggregateEntity store(SurveyAggregateEntity survey);
	public SurveyAggregateEntity get(Long id) throws ResourceNotFoundException;
	public SurveyAggregateEntity storeUserResponse(SurveyAggregateEntity surveyResponse) throws ResourceNotFoundException ;
	public SurveySummaryModel getSurveyStatictics(Long surveyId,Long questionId) throws ResourceNotFoundException ;
}
