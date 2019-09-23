package com.marketlogic.assignment.questionservice.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketlogic.assignment.questionservice.entity.AnswersEntity;
import com.marketlogic.assignment.questionservice.entity.QuestionEntity;
import com.marketlogic.assignment.questionservice.exception.ResourceNotFoundException;
import com.marketlogic.assignment.questionservice.repository.QuestionRepository;
import com.marketlogic.assignment.questionservice.service.QuestionService;
import com.marketlogic.assignment.questionservice.util.ServiceUtil;
/**
 * This service class is responsible for providing all Repository interactions
 * @author Sougata Maitra
 *
 */
@Service
@Transactional
public class QuestionServiceImpl implements QuestionService{

	@Autowired
	QuestionRepository questionRepository;
	
	public QuestionEntity addQuestion(QuestionEntity question) {
		// TODO Auto-generated method stub
		return questionRepository.save(question);
	}

	public QuestionEntity findById(Long id) {
		// TODO Auto-generated method stub
		return questionRepository.findById(id).get();
	}
	public List<QuestionEntity> getAllQuestions(){
		return questionRepository.findAll();
	}
	
	/**
	 * This method is used for updating a question. Existing answers to the question will not be modified in this operation.
	 * If no question found for the given question entity then it will throw ResourceNotFoundException
	 * @throws ResourceNotFoundException 
	 */
	public QuestionEntity updateQuestion(QuestionEntity questionEntity) throws ResourceNotFoundException {
		QuestionEntity question = questionRepository.findById(questionEntity.getQuestionId()).get(); 
		if(question==null) {
			throw new ResourceNotFoundException(ServiceUtil.INVALID_QUESTION_DESC, ServiceUtil.INVALID_QUESTION_EX_CODE);
		}
		questionEntity.setPossibleAnswers(question.getPossibleAnswers());
		return questionRepository.save(questionEntity);
	}
	/**
	 * This method adds answer to a question . It will only add answers to existing questions. If no question is found then it throws ResourceNotFoundException
	 */
	public QuestionEntity addAnswersToQuestion(QuestionEntity question) {
		// TODO Auto-generated method stub
		return questionRepository.save(question);
	}
	/**
	 * This method soft deletes Question and set delete flag as Y , so that data will not be lost .
	 * Also, as no validation rules are defined , it can so happened Survey is already create with this question . It can either check if any survey using it or not .Since , this rule is 
	 * not explicitly mentioned , once  hard delete is done there will be no way to retrieve question description used in survey. 
	 * Ideally , it should check if any question which is requested for deleted , is being using by any survey or not. 
	 */
	
	public void deleteQuestion(Long id) throws ResourceNotFoundException {
		QuestionEntity questionEntity = questionRepository.findById(id).get(); 
		if(questionEntity==null) {
			throw new ResourceNotFoundException(ServiceUtil.INVALID_QUESTION_DESC, ServiceUtil.INVALID_QUESTION_EX_CODE);
		}
		questionEntity.setDeleteYN("Y");
		questionRepository.save(questionEntity);
	}
	
	/**
	 * This method deletes answer to a question. If no question is found for given question id , it throws resource not found exception.
	 * Also if no question is found for that question it also throws resource not found exception
	 */
	
	public void deleteAnswerToQuestion(Long questionId,Long answerId)   throws ResourceNotFoundException{
		QuestionEntity questionEntity = questionRepository.findById(questionId).get(); 
		if(questionEntity==null) {
			throw new ResourceNotFoundException(ServiceUtil.INVALID_QUESTION_DESC, ServiceUtil.INVALID_QUESTION_EX_CODE);
		} 
		boolean isMatch = false;
		for(AnswersEntity answerEntity: questionEntity.getPossibleAnswers()) {
			if(answerEntity.getAnswerId().longValue()==answerId.longValue()) {
				questionEntity.removePossibleAnswers(answerEntity);
				isMatch = true;
				break;
			}
		}
		if(!isMatch) {
			throw new ResourceNotFoundException(ServiceUtil.INVALID_QUESTION_DESC, ServiceUtil.INVALID_QUESTION_EX_CODE);
		}
		questionRepository.save(questionEntity);
	}
	
	
	
	
}
