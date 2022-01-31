package com.example.firstCommit;

import com.example.firstCommit.entities.Candidate;
import com.example.firstCommit.entities.Tag;
import com.example.firstCommit.entities.User;
import com.example.firstCommit.repository.CandidateRepository;
import com.example.firstCommit.repository.TagRepository;
import com.example.firstCommit.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FirstCommitApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(FirstCommitApplication.class, args);

		//CANDIDATE
		CandidateRepository candidateRepository = context.getBean(CandidateRepository.class);

		Candidate candidate1 = new Candidate(
				null,
				"name1",
				"lastaname1",
				"candidate1@gmail.com",
				"Medellin",
				"Colombia",
				true,
				true,
				"54678798983"
		);
		candidateRepository.save(candidate1);

		//TAG

		TagRepository tagRepository = context.getBean(TagRepository.class);

		Tag tag1 = new Tag(null, "tag1");
		Tag tag2 = new Tag(null, "tag2");
		tagRepository.save(tag1);
		tagRepository.save(tag2);


		//USER

		UserRepository userRepository = context.getBean(UserRepository.class);

		User user1 = new User(null, "usuario1@gmail.com", "1234");

		userRepository.save(user1);

		//ASOCIACION USER-CANDIDATES

		user1.getCandidates().add(candidate1);


		//ASOCIACION USER-ETIQUETAS

		candidate1.getTags().add(tag1);
		candidate1.getTags().add(tag2);

		candidateRepository.save(candidate1);



	}

}
