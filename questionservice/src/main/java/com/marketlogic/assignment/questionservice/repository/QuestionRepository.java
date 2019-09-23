package com.marketlogic.assignment.questionservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.marketlogic.assignment.questionservice.entity.QuestionEntity;

@Repository
public interface QuestionRepository  extends JpaRepository <QuestionEntity,Long>{
	
	
}
