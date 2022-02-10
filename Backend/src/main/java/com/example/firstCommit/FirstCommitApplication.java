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
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootApplication
public class FirstCommitApplication {


//	@Bean
//	public PasswordEncoder passwordEncoder(){
//		return new BCryptPasswordEncoder();
//	}

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(FirstCommitApplication.class, args);

		//ENCODER

//		PasswordEncoder encoder = context.getBean(PasswordEncoder.class);

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

		Candidate candidate2 = new Candidate(
				null,
				"name2",
				"lastaname2",
				"candidate2@gmail.com",
				"Medellin",
				"Colombia",
				true,
				true,
				"54678798983"
		);

		Candidate candidate3 = new Candidate(
				null,
				"name3",
				"lastaname3",
				"candidate3@gmail.com",
				"Barcelona",
				"España",
				false,
				false,
				"54678798983"
		);
		//candidateRepository.save(candidate1);
		//candidateRepository.save(candidate2);
		candidateRepository.saveAll(List.of(candidate1, candidate2, candidate3));


		//TAG

		TagRepository tagRepository = context.getBean(TagRepository.class);

		Tag tag1 = new Tag(null, "tag1");
		Tag tag2 = new Tag(null, "tag2");
		Tag tag3 = new Tag(null, "tag3");

		tagRepository.save(tag1);
		tagRepository.save(tag2);
		tagRepository.save(tag3);


		//USER

		/*UserRepository userRepository = context.getBean(UserRepository.class);

		User user1 = new User(null,"user1","user1@gmail.com", "user1");

		userRepository.save(user1);
		//System.out.println("ENCRYPTED PASSWORD" + user1.getPassword());*/

		//ASOCIACION USER-CANDIDATES

		//user1.getCandidates().add(candidate1);


		//ASOCIACION CANDIDATO-ETIQUETAS
		candidate1.getTags().add(tag1);
		//candidateRepository.save(candidate1);

		candidate2.getTags().add(tag1);
		//candidateRepository.save(candidate2);

		candidateRepository.saveAll(List.of(candidate1,candidate2));

		//ASOCIACION ETIQUETA-CANDIDATO

		tag1.getCandidates().add(candidate1);
		tag1.getCandidates().add(candidate2);
		tagRepository.save(tag1);





	}

}
