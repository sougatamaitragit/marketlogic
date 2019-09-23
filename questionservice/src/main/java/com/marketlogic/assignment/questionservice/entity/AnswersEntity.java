package com.marketlogic.assignment.questionservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "POSSIBLE_ANSWRE_TAB")
public class AnswersEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long answerId;
	
	@Column(name="ANSWER_DESC")
	String answerDescription;
	
	@ManyToOne
	QuestionEntity question;
	 
	
	public Long getAnswerId() {
		return answerId;
	}
	public void setAnswerId(Long answerId) {
		this.answerId = answerId;
	}
	public String getAnswerDescription() {
		return answerDescription;
	}
	public void setAnswerDescription(String answerDescription) {
		this.answerDescription = answerDescription;
	}
	public QuestionEntity getQuestion() {
		return question;
	}
	public void setQuestion(QuestionEntity question) {
		this.question = question;
	}
	
	
	
	

}
