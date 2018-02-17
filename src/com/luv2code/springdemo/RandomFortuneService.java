package com.luv2code.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
	
	private String[] fortunes = {
			"Beware of the wolf in sheep's clothing",
			"Diligence is the mother of good luck",
			"The journey is the reward"
	};

	// create a random number generator
	private Random random = new Random();
	
	@Override
	public String getFortune() {
		int index = random.nextInt(fortunes.length);
		
		return fortunes[index];
	}

}
