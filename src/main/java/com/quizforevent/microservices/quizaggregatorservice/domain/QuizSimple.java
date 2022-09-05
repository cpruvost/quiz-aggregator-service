package com.quizforevent.microservices.quizaggregatorservice.domain;


public class QuizSimple {
	private Integer Id;
	private String name;
	private String environment;
	
	public QuizSimple() {
		super();
	}

	public QuizSimple(Integer id, String name, String environment) {
		super();
		Id = id;
		this.name = name;
		this.environment = environment;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	@Override
	public String toString() {
		return "QuizSimple [Id=" + Id + ", name=" + name + ", environment=" + environment + "]";
	}
	
}
