package com.luv2code.springdemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class FileFortuneService implements FortuneService {

	private String fileName = "C:/Users/Terry/eclipse-workspace/spring-demo-annotations/src/fortune-data.txt";
	private List<String> fortunes;
	
	private Random rand = new Random();
	
	@PostConstruct
	public void readInFiles() {
		File theFile = new File(fileName);
		System.out.println("Reading fortunes from file: " + fileName);
		System.out.println("File exists: " + theFile.exists());
		
		fortunes = new ArrayList<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(theFile))) {
			
			String line;
			while ((line = br.readLine()) != null) {
				fortunes.add(line);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Files have been read in...");
	}
	
	@Override
	public String getFortune() {
		int index = rand.nextInt(fortunes.size());
		
		return fortunes.get(index);
	}

}
