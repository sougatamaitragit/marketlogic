package com.marketlogic.assigment.surveyservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class SurveyResponseQuestionAnswer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long questionId;
	private Long answerId;
	
	@ManyToOne
	SurveyUserResponse surveyResponse;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public Long getAnswerId() {
		return answerId;
	}

	public void setAnswerId(Long answerId) {
		this.answerId = answerId;
	}

	public SurveyUserResponse getSurveyResponse() {
		return surveyResponse;
	}

	public void setSurveyResponse(SurveyUserResponse surveyResponse) {
		this.surveyResponse = surveyResponse;
	}
	
	

}
