package com.marketlogic.assignment.questionservice.service;

import java.util.List;

import com.marketlogic.assignment.questionservice.entity.QuestionEntity;
import com.marketlogic.assignment.questionservice.exception.ResourceNotFoundException;

public interface QuestionService {
	
	public QuestionEntity addQuestion(QuestionEntity question);
	public QuestionEntity findById(Long id);
	public List<QuestionEntity> getAllQuestions();
    public QuestionEntity updateQuestion(QuestionEntity questionEntity) throws ResourceNotFoundException;
    public void deleteQuestion(Long id) throws ResourceNotFoundException;
	public QuestionEntity addAnswersToQuestion(QuestionEntity question);
	public void deleteAnswerToQuestion(Long questionId,Long answerId)   throws ResourceNotFoundException;
	
}
