package com.UserAPI.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.UserAPI.Model.Commentary;
import com.UserAPI.Model.Post;
import com.UserAPI.Model.User;
import com.UserAPI.enums.Gender;
import com.UserAPI.repositories.CommentaryRepository;
import com.UserAPI.repositories.PostRepository;
import com.UserAPI.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private CommentaryRepository commentaryRepository;

	@Override
	public void run(String... args) throws Exception {

		User u1 = new User(null, "Miss", "Jennie", "Nichols",
				"48df5229235ada28389b91e60a935e4f9b73eb4bdb855ef9258a1751f10bdc5d", "USA", "jennie.nichols@example.com",
				Gender.F);

		User u2 = new User(null, "Mr", "Comedor de Casadas", null, "1231241235125123516", "BR", "aaaaaa@gmail.com",
				Gender.M);

		Post p1 = new Post(null, u1, "sexo", Instant.parse("2019-06-20T19:53:07Z"));
		Post p2 = new Post(null, u2, "AAAAAAAAAAA", Instant.parse("2022-06-20T23:53:07Z"));
		Post p3 = new Post(null, u1, "BBBBBBBBBBB", Instant.parse("2022-06-20T23:53:07Z"));
		Post p4 = new Post(null, u2, "CCCCCCCCCCC", Instant.parse("2022-06-20T23:53:07Z"));

		u1.getPosts().add(p1);
		u2.getPosts().add(p2);
		u2.getPosts().add(p3);
		u1.getPosts().add(p4);
		System.out.println(u1);
		System.out.println(u2);

		Commentary c1 = new Commentary(null, u1, p1, "gosto também", null, 69);
		Commentary c2 = new Commentary(null, u2, p1, "yes", null, 65);
		Commentary c3 = new Commentary(null, u2, p2, "no", null, 44);
		Commentary c4 = new Commentary(null, u1, p2, "maybe", null, 31);

		userRepository.saveAll(Arrays.asList(u1, u2));
		postRepository.saveAll(Arrays.asList(p1, p2, p3, p4));
		commentaryRepository.saveAll(Arrays.asList(c1, c2, c3, c4));

	}

}