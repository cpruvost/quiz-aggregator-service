package com.quizforevent.microservices.quizaggregatorservice.api;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.quizforevent.microservices.quizaggregatorservice.domain.Quiz;

@FeignClient(name = "quiz-service", url = "${QUIZ_URI:http://localhost}:8000")
public interface QuizServiceProxy {
	@GetMapping("/quizzes")
	public List<Quiz> retrieveExchangeValue();
}
