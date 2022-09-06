package com.quizforevent.microservices.quizaggregatorservice.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.quizforevent.microservices.quizaggregatorservice.domain.QuizAggregator;

@FeignClient(name = "quiz-service", url = "${QUIZ_URI:http://localhost}:8000")
public interface QuizServiceProxy {
	@GetMapping("/quizaggregator")
	public QuizAggregator retrieveExchangeValue();
}
