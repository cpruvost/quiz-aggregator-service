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

import com.quizforevent.microservices.quizaggregatorservice.domain.QuizAggregator;

@RestController
public class QuizAggregatorController {
	private Logger logger = LoggerFactory.getLogger(QuizAggregatorController.class);
	
	@Autowired
	private QuizServiceProxy proxy;

	@GetMapping("/quizaggregator")
	public ResponseEntity<QuizAggregator> getQuizAggregatorFeign() {
		try {		
		
			logger.info("getQuizAggregatorFeign");
	
			QuizAggregator quizAggregator = proxy.retrieveExchangeValue();
			
			
			if (quizAggregator == null) {
			  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			      
			return new ResponseEntity<>(quizAggregator, HttpStatus.OK);
		}
		  catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
		
		
	}
}
