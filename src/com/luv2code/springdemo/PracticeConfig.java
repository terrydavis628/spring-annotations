package com.luv2code.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PracticeConfig {
	
	@Bean
	public FortuneService practiceFortuneService() {
		return new PracticeFortuneService();
	}
	
	@Bean
	public Coach practiceCoach() {
		return new PracticeCoach(practiceFortuneService());
	}
}
