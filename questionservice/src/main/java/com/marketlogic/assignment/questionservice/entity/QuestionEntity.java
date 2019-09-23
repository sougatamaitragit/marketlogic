package com.marketlogic.assignment.questionservice.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "QUESTION_TAB")
public class QuestionEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long questionId;
	 
	@Column(name="QUESTION_DESC")
	String questionDescription;
	
	@Column(name="DELETE_YN")
	String deleteYN;
	
	@OneToMany(cascade=CascadeType.ALL)
    List<AnswersEntity> possibleAnswers;
	 
	public Long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}
	public String getQuestionDescription() {
		return questionDescription;
	}
	public void setQuestionDescription(String questionDescription) {
		this.questionDescription = questionDescription;
	}
	public List<AnswersEntity> getPossibleAnswers() {
		return possibleAnswers;
	}
	public void setPossibleAnswers(List<AnswersEntity> possibleAnswers) {
		this.possibleAnswers = possibleAnswers;
	}
	public String getDeleteYN() {
		return deleteYN;
	}
	public void setDeleteYN(String deleteYN) {
		this.deleteYN = deleteYN;
	}
	
	public void removePossibleAnswers(AnswersEntity answer) {
		possibleAnswers.remove(answer);
		answer.setQuestion(this);
	}
	
	public void addPossibleAnswers(AnswersEntity answer) {
		possibleAnswers.add(answer);
		
	}

}
