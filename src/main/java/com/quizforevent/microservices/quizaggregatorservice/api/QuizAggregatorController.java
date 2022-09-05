package com.quizforevent.microservices.quizaggregatorservice.api;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quizforevent.microservices.quizaggregatorservice.domain.Quiz;
import com.quizforevent.microservices.quizaggregatorservice.domain.QuizSimple;

@RestController
public class QuizAggregatorController {
	private Logger logger = LoggerFactory.getLogger(QuizAggregatorController.class);
	
	@Autowired
	private QuizServiceProxy proxy;

	@GetMapping("/quizaggregator")
	public ResponseEntity<List<QuizSimple>> getQuizSimpleListFeign() {
		try {		
		
			logger.info("quizaggregator");
	
			List<Quiz> quizzes = proxy.retrieveExchangeValue();
			
			List<QuizSimple> quizSimpleList = new ArrayList<QuizSimple>();
			
			for (Quiz quiz : quizzes) {
		    	QuizSimple quizSimple = new QuizSimple();
		    	quizSimple.setId(quiz.getId());
		    	quizSimple.setName(quiz.getName());
		    	quizSimple.setEnvironment(quiz.getEnvironment());
		    	quizSimpleList.add(quizSimple);
		    }
			
			if (quizSimpleList.isEmpty()) {
			  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			      
			return new ResponseEntity<>(quizSimpleList, HttpStatus.OK);
		}
		  catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
		
		
	}
}
