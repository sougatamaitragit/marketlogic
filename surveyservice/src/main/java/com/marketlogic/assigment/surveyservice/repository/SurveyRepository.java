package com.marketlogic.assigment.surveyservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marketlogic.assigment.surveyservice.entity.SurveyAggregateEntity;


@Repository
public interface SurveyRepository  extends JpaRepository <SurveyAggregateEntity,Long>{ 

}
