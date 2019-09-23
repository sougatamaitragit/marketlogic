package com.marketlogic.assigment.surveyservice.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SURVEY")
public class SurveyAggregateEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String surveyDesc;
	
	@OneToMany(cascade=CascadeType.ALL)
	List<SurveyQuestions> surveyQuestions; 
	 
	@OneToMany(cascade=CascadeType.ALL)
	List<SurveyUserResponse> surveyUserResponse;
	
	public Long getId() {
		return id; 
	} 
	public void setId(Long id) {
		this.id = id;
	} 
	public String getSurveyDesc() {
		return surveyDesc;
	}
	public void setSurveyDesc(String surveyDesc) {
		this.surveyDesc = surveyDesc;
	}
	public List<SurveyQuestions> getSurveyQuestions() {
		return surveyQuestions;
	}
	public void setSurveyQuestions(List<SurveyQuestions> surveyQuestions) {
		this.surveyQuestions = surveyQuestions;
	}
	public List<SurveyUserResponse> getSurveyUserResponse() {
		return surveyUserResponse;
	}
	public void setSurveyUserResponse(List<SurveyUserResponse> surveyUserResponse) {
		this.surveyUserResponse = surveyUserResponse;
	}
	
	public Map<Long,Integer> surveyStatistics(Long questionId) {
		Map<Long,Integer> surveyAnswerStatMap = new HashMap<Long,Integer>();
		for(SurveyUserResponse surveyResponse: surveyUserResponse) {
			for(SurveyResponseQuestionAnswer surveyAnswer: surveyResponse.getSurveyAnswerList()) {
				if(surveyAnswer.getQuestionId().longValue()==questionId.longValue()) {
					if(!surveyAnswerStatMap.containsKey(surveyAnswer.getAnswerId())) {
						surveyAnswerStatMap.put(surveyAnswer.getAnswerId(), new Integer(1));
					}else {
						surveyAnswerStatMap.put(surveyAnswer.getAnswerId(), surveyAnswerStatMap.get(surveyAnswer.getAnswerId())+1);
					}
					
					
				}
			}
		}
		return surveyAnswerStatMap;
		
	}
	
	
	
	
	
	
	
	

}
