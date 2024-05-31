package com.tutorial;

import com.tutorial.entity.Tutorial;
import com.tutorial.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class TutorialProjectApplication implements CommandLineRunner {
	@Autowired
	private TutorialRepository tutorialRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(TutorialProjectApplication.class, args);
		System.out.println("Application is Running...");
	}
	
	@Override
	public void run(String... args) throws Exception {
		List<Tutorial> tutorialList = new ArrayList<>();
		for (int i = 1; i <= 32; i++) {
			String title = "Tutorial Title " + i;
			String description = "Tutorial Description " + i;
			int random = new Random().nextInt(2);
			Boolean isPublished = random == 1;
			tutorialList.add(new Tutorial(title, description, isPublished));
		}
		
		if (tutorialRepository.count() < 1) {
			tutorialRepository.saveAll(tutorialList);
		}
	}
}
