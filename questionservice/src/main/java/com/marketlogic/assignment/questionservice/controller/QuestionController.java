package com.marketlogic.assignment.questionservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.marketlogic.assignment.questionservice.entity.QuestionEntity;
import com.marketlogic.assignment.questionservice.exception.ResourceNotFoundException;
import com.marketlogic.assignment.questionservice.service.QuestionService;
/**
 * This class is responsible for exposing Rest services for Questions and Answers management
 * @author Sougata Maitra
 * @version 1.0
 */
@RestController
public class QuestionController {
	
	@Autowired
	QuestionService questionService;
	/** 
	 * This method is used for creating Questions
	 * @param question
	 * @return
	 */
	@PostMapping(value="/question",produces = { MediaType.APPLICATION_JSON_VALUE },consumes= { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(HttpStatus.CREATED)
	public  QuestionEntity   storeQuestion(@RequestBody QuestionEntity question) {
		return questionService.addQuestion(question);
	}
	/**
	 * This method is used for get questions and answer by question id
	 * @param id
	 * @return
	 */
	@GetMapping(value="/question/{id}",produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(HttpStatus.OK)
	public  QuestionEntity   getQuestion(@PathVariable("id") Long id) {
		return questionService.findById(id); 
		
	}
	/**
	 * This method is responsible for getting all Question
	 * @return
	 */
	@GetMapping(value="/question",produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(HttpStatus.OK)
	public  List<QuestionEntity>   getAllQuestion() {
		return questionService.getAllQuestions();
		
	}
	
	/**
	 * This method is used for updating a question only . 
	 * @param question
	 * @return
	 * @throws ResourceNotFoundException 
	 */
	@PutMapping(value="/question", produces = { MediaType.APPLICATION_JSON_VALUE },consumes= { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(HttpStatus.OK)
	public QuestionEntity updateQuestion(@RequestBody QuestionEntity question) throws ResourceNotFoundException {
		
		return questionService.updateQuestion(question);
	}
	
	/**
	 * This is used for deleting questions
	 * @param id
	 * @throws ResourceNotFoundException
	 */
	@DeleteMapping(value="/question/{id}",produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public  void   deleteQuestion( @PathVariable("id") Long id) throws ResourceNotFoundException {
		 questionService.deleteQuestion(id);
		
	}
	
	
	
	
	/**
	 * This is used for Add answer to a  Question
	 * @param question
	 * @return
	 */
	@PutMapping(value="/question/answers",produces = { MediaType.APPLICATION_JSON_VALUE },consumes= { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(HttpStatus.OK)
	public  QuestionEntity   storeAnswerToQuestion(@RequestBody QuestionEntity question) {
		return questionService.addAnswersToQuestion(question);
		
	}
	
	/**
	 * This is used for deleting answer to a question
	 * @param id 
	 * @throws ResourceNotFoundException
	 */
	@DeleteMapping(value="/question/{questionid}/answer/{answerid}",produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public  void   deleteAnswerToAQuestion( @PathVariable("questionid") Long questionid, @PathVariable("answerid") Long answerid ) throws ResourceNotFoundException {
		 questionService.deleteAnswerToQuestion(questionid,answerid);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
