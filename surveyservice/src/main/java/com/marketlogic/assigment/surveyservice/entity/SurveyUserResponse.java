package com.marketlogic.assigment.surveyservice.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class SurveyUserResponse {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String userId;
	
	
	@OneToMany
	private List<SurveyAggregateEntity> participatedSurveyList;
	
	
	@OneToMany(cascade= CascadeType.ALL)
	private List<SurveyResponseQuestionAnswer> surveyAnswerList;
	
	
	public List<SurveyResponseQuestionAnswer> getSurveyAnswerList() { 
		return surveyAnswerList;
	}

	public void setSurveyAnswerList(List<SurveyResponseQuestionAnswer> surveyAnswerList) {
		this.surveyAnswerList = surveyAnswerList;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public List<SurveyAggregateEntity> getParticipatedSurveyList() {
		return participatedSurveyList;
	}

	public void setParticipatedSurveyList(List<SurveyAggregateEntity> participatedSurveyList) {
		this.participatedSurveyList = participatedSurveyList;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	
	
	

}
