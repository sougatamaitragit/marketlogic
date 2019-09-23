package com.marketlogic.assigment.surveyservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.marketlogic.assigment.surveyservice.entity.SurveyAggregateEntity;
import com.marketlogic.assigment.surveyservice.exception.ResourceNotFoundException;
import com.marketlogic.assigment.surveyservice.model.SurveySummaryModel;
import com.marketlogic.assigment.surveyservice.service.SurveyService;

/**
 * This class is responsible for exposing all REST Services
 * @author Sougata Maitra
 *
 */
@RestController
public class SurveyController { 
	
	
	@Autowired 
	SurveyService surveyService;

	@PostMapping(value="/survey",produces = { MediaType.APPLICATION_JSON_VALUE },consumes= { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(HttpStatus.CREATED)
	public  SurveyAggregateEntity   store(@RequestBody SurveyAggregateEntity survey) {
		return surveyService.store(survey);
	} 
	
	@GetMapping(value="/survey/{surveyid}",produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(HttpStatus.OK)
	public  SurveyAggregateEntity   getQuestion(@PathVariable("surveyid") Long id)  throws ResourceNotFoundException{
		return surveyService.get(id);
		
	} 
	/**
	 * This Rest Service Stores Statictics to a Survey 
	 * @param surveyAggregate
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@PostMapping(value="/survey/userresponse",produces = { MediaType.APPLICATION_JSON_VALUE },consumes= { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(HttpStatus.OK)
	public  SurveyAggregateEntity   storeUserResponse(@RequestBody SurveyAggregateEntity surveyAggregate)  throws ResourceNotFoundException{
		
		SurveyAggregateEntity aggregateEntity = surveyService.storeUserResponse(surveyAggregate);
		return aggregateEntity;
	} 
	
	/**
	 * This service exposed statistics of answer to a question of a Survey
	 * @param surveyId
	 * @param questionId
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@GetMapping(value="/survey/{surveyId}/question/{questionId}/statistics",produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(HttpStatus.OK)
	public  SurveySummaryModel   getSurveyStatictics(@PathVariable("surveyId") Long surveyId, @PathVariable("questionId") Long questionId)  throws ResourceNotFoundException{
		return  surveyService.getSurveyStatictics(surveyId, questionId);
	} 
	

}
