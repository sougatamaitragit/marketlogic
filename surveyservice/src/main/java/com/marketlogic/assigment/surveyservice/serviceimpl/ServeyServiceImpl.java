package com.marketlogic.assigment.surveyservice.serviceimpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketlogic.assigment.surveyservice.entity.SurveyAggregateEntity;
import com.marketlogic.assigment.surveyservice.exception.ResourceNotFoundException;
import com.marketlogic.assigment.surveyservice.model.SurveySummaryModel;
import com.marketlogic.assigment.surveyservice.repository.SurveyRepository;
import com.marketlogic.assigment.surveyservice.service.SurveyService;
import com.marketlogic.assigment.surveyservice.util.ServiceUtil;
/**
 * This service class is responsible for interacting with Survey Repository
 * @author Sougata Maitra
 *
 */
@Service
@Transactional
public class ServeyServiceImpl implements SurveyService{
	
	@Autowired
	SurveyRepository surveyRepository; 
	
	public SurveyAggregateEntity store(SurveyAggregateEntity survey) {
		
		return surveyRepository.save(survey);
		
	}
	public SurveyAggregateEntity get(Long id) throws ResourceNotFoundException {
		Optional<SurveyAggregateEntity> surveyAggregateOptional =  surveyRepository.findById(id);
		SurveyAggregateEntity surveyEntity = surveyAggregateOptional.get();
		if(surveyEntity==null) {
			throw new ResourceNotFoundException(ServiceUtil.INVALID_QUESTION_EX_CODE,ServiceUtil.INVALID_QUESTION_DESC);
		}
		return surveyEntity; 
	}
	
	
	public SurveyAggregateEntity storeUserResponse(SurveyAggregateEntity surveyAggregate) throws ResourceNotFoundException {
		Optional<SurveyAggregateEntity> surveyAggregateOptional =  surveyRepository.findById(surveyAggregate.getId());
		SurveyAggregateEntity surveyEntity = surveyAggregateOptional.get();
		if(surveyEntity==null) {
			throw new ResourceNotFoundException(ServiceUtil.INVALID_QUESTION_EX_CODE,ServiceUtil.INVALID_QUESTION_DESC);
		}
		
		if(surveyEntity.getSurveyUserResponse()!=null && surveyEntity.getSurveyUserResponse().size()>0) {
			surveyEntity.getSurveyUserResponse().addAll(surveyAggregate.getSurveyUserResponse());
			
		}else {
			surveyEntity.setSurveyUserResponse(surveyAggregate.getSurveyUserResponse());
		}
		
		return surveyRepository.save(surveyEntity);  
		
	}
	
	
	public SurveySummaryModel getSurveyStatictics(Long surveyId,Long questionId) throws ResourceNotFoundException {
		Optional<SurveyAggregateEntity> surveyAggregateOptional =  surveyRepository.findById(surveyId);
		SurveyAggregateEntity surveyEntity = surveyAggregateOptional.get();
		if(surveyEntity==null) {
			throw new ResourceNotFoundException(ServiceUtil.INVALID_QUESTION_EX_CODE,ServiceUtil.INVALID_QUESTION_DESC);
		}
		Map<Long,Integer> surveyStaticticsMap = surveyEntity.surveyStatistics(questionId);
		int count = 0;
		for (Map.Entry<Long,Integer> entry : surveyStaticticsMap.entrySet())  {
			System.out.println(":::::::: entry ::::::::::"+entry);
			count = count + entry.getValue();
        }
		SurveySummaryModel summaryModel = new SurveySummaryModel();
		summaryModel.setResponseCount(count);
		Map <Long,Float>  distributionMap = new HashMap<Long,Float> ();
		for (Map.Entry<Long,Integer> entry : surveyStaticticsMap.entrySet())  {
			float distributionFraction  = (float) entry.getValue() / count; 
			distributionMap.put(entry.getKey(),distributionFraction);
        }
		summaryModel.setAnswerDistributionToQuestion(distributionMap);
		return summaryModel;
	}
	
	

}
