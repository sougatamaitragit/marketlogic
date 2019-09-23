package com.marketlogic.assigment.surveyservice.model;

import java.util.HashMap;
import java.util.Map;

public class SurveySummaryModel {
	
	private int responseCount;
	private Map<Long,Float> answerDistributionToQuestion = new HashMap<Long,Float>();
	
	public int getResponseCount() {
		return responseCount;
	}
	public void setResponseCount(int responseCount) {
		this.responseCount = responseCount;
	}
	public Map<Long, Float> getAnswerDistributionToQuestion() {
		return answerDistributionToQuestion;
	}
	public void setAnswerDistributionToQuestion(Map<Long, Float> answerDistributionToQuestion) {
		this.answerDistributionToQuestion = answerDistributionToQuestion;
	}
	
	

}
