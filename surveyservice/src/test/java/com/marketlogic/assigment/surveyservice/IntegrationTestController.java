package com.marketlogic.assigment.surveyservice;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import com.marketlogic.assigment.surveyservice.entity.SurveyAggregateEntity;
import com.marketlogic.assigment.surveyservice.entity.SurveyQuestions;
import com.marketlogic.assigment.surveyservice.entity.SurveyResponseQuestionAnswer;
import com.marketlogic.assigment.surveyservice.entity.SurveyUserResponse;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class IntegrationTestController {
	
	@LocalServerPort
    int port;
	
	@Before
    public void setUp() {
        RestAssured.port = port;
    }  
	@Test
	public void test_addQuestions() {
		
		SurveyAggregateEntity surveyAggregate = new SurveyAggregateEntity();
		surveyAggregate.setSurveyDesc("F1 Best Driver Survey");
		
		List<SurveyQuestions> surveyQuestionsList = new ArrayList<SurveyQuestions>();
		SurveyQuestions surveyQn1 = new SurveyQuestions();
		surveyQn1.setQuestionid(1l);
		surveyQuestionsList.add(surveyQn1);
		surveyAggregate.setSurveyQuestions(surveyQuestionsList);
		 given().contentType(ContentType.JSON).body(surveyAggregate)
		.when()
        .post("/survey")
        .then()
        .statusCode(201).and().assertThat().body("id", greaterThan(0));
		 
	}
	
	@Test
	public void testb_getSurvey() {
		 given()
	      .when().get("/survey/1") 
	      .then().statusCode(200).and().assertThat().body("surveyDesc", equalTo("F1 Best Driver Survey"));;
		
	}
	
	@Test
	public void testc_storeUserResponse() {
		
		SurveyAggregateEntity surveyAggregate = new SurveyAggregateEntity();
		surveyAggregate.setId(1l); 
		
		List<SurveyUserResponse> userResponsList = new ArrayList<SurveyUserResponse>();
		List<SurveyResponseQuestionAnswer> answerlist = new ArrayList<SurveyResponseQuestionAnswer>();
		
		SurveyUserResponse userresponse1 = new SurveyUserResponse();
		userresponse1.setUserId("USER001");
		surveyAggregate.setSurveyUserResponse(userResponsList);
		SurveyResponseQuestionAnswer surveyAnswer1 = new SurveyResponseQuestionAnswer();
		SurveyResponseQuestionAnswer surveyAnswer2 = new SurveyResponseQuestionAnswer();
		 
		surveyAnswer1.setQuestionId(1l);
		surveyAnswer1.setAnswerId(1l);
		surveyAnswer2.setQuestionId(2l);
		surveyAnswer2.setAnswerId(1l);
		
		
		answerlist.add(surveyAnswer1);
		answerlist.add(surveyAnswer2); 
		userresponse1.setSurveyAnswerList(answerlist);
		userResponsList.add(userresponse1);
		/*
		 *  SurveyResponseQuestionAnswer surveyAnswer3 = new SurveyResponseQuestionAnswer();
			SurveyResponseQuestionAnswer surveyAnswer4 = new SurveyResponseQuestionAnswer();
			surveyAnswer3.setQuestionId(1l);
			surveyAnswer3.setAnswerId(1l);
			surveyAnswer4.setQuestionId(2l);
			surveyAnswer4.setAnswerId(1l);
		 
		 */
		   given().contentType(ContentType.JSON).body(surveyAggregate)
	      .when().post("/survey/userresponse") 
	      .then().statusCode(200).and().assertThat().body("id", equalTo(1));
		   
		   /************ ADD ANOTHER ***************/
	    
		   SurveyAggregateEntity surveyAggregateanother = new SurveyAggregateEntity();
		   surveyAggregateanother.setId(1l); 
		   
		   List<SurveyUserResponse> userResponsListAnother = new ArrayList<SurveyUserResponse>();
		   List<SurveyResponseQuestionAnswer> answerlistAnother = new ArrayList<SurveyResponseQuestionAnswer>();
			
			SurveyUserResponse userresponse2 = new SurveyUserResponse();
			userresponse2.setUserId("USER002");
			surveyAggregateanother.setSurveyUserResponse(userResponsListAnother);
			
			SurveyResponseQuestionAnswer surveyAnswer3 = new SurveyResponseQuestionAnswer();
			SurveyResponseQuestionAnswer surveyAnswer4 = new SurveyResponseQuestionAnswer();
			 
			surveyAnswer3.setQuestionId(1l);
			surveyAnswer3.setAnswerId(1l);
			surveyAnswer4.setQuestionId(2l);
			surveyAnswer4.setAnswerId(1l);
			  
			answerlistAnother.add(surveyAnswer3);
			answerlistAnother.add(surveyAnswer4); 
			userresponse2.setSurveyAnswerList(answerlistAnother);
			userResponsListAnother.add(userresponse2);
			
			 given().contentType(ContentType.JSON).body(surveyAggregate)
		      .when().post("/survey/userresponse") 
		      .then().statusCode(200).and().assertThat().body("surveyUserResponse", hasSize(2));
		  
		    
		
	}
	
	@Test
	public void testd_showstats() {
		
		 given()
	    .when().get("/survey/1/question/1/statistics") 
	    .then().statusCode(200);
		
		
	}
 
 
}
