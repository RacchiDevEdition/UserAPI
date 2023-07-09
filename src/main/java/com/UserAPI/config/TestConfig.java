package com.UserAPI.config;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.UserAPI.Model.Post;
import com.UserAPI.Model.User;
import com.UserAPI.Model.UserPost;
import com.UserAPI.enums.Gender;
import com.UserAPI.repositories.PostRepository;
import com.UserAPI.repositories.UserPostRepository;
import com.UserAPI.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private UserPostRepository userPostRepository;

	@Override
	public void run(String... args) throws Exception {

		Post p1 = new Post(null, null, "sexo", Instant.parse("2019-06-20T19:53:07Z"));
		User u1 = new User(null, "Miss", "Jennie", "Nichols",
				"48df5229235ada28389b91e60a935e4f9b73eb4bdb855ef9258a1751f10bdc5d", "USA", "jennie.nichols@example.com",
				Gender.F);
		

		u1.getPosts().add(p1);
		p1.setCreator(u1);


		UserPost up1 = new UserPost(p1, u1);

		
		userRepository.save(u1);
		postRepository.save(p1);
		userPostRepository.save(up1);

		System.out.println(u1);
		System.out.println(p1);
		System.out.println(up1);

	}

}