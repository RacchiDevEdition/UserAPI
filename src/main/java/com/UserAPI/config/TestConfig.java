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

		User u2 = new User(null, "Mr", "Zacos", "Accel", "zacos123", "USA", "zacos@gmail.com", Gender.M);
		User u3 = new User(null, "Mr", "Duraobra", "Duro", "dura123", "JP", "dura@gmail.com", Gender.M);
		User u4 = new User(null, "Mr", "Nixyure", "Axford", "nix123", "BR", "nix@gmail.com", Gender.M);
		User u5 = new User(null, "Mr", "Sigoa", "Dragon", "sigos123", "TR", "sigo@gmail.com", Gender.M);
		User u6 = new User(null, "Miss", "Rita", "Astreude", "ritinha123", "JP", "rita@gmail.com", Gender.F);
		User u7 = new User(null, "Miss", "Rayna", "Draxxar", "rayray123", "JP", "ray@gmail.com", Gender.F);
		User u8 = new User(null, "Miss", "Aiko", "Yoshida", "kirara123", "JP", "quimera@gmail.com", Gender.F);
		User u9 = new User(null, "Mr", "Soma", "", "soma123", "BR", "soma@gmail.com", Gender.M);
		User u10 = new User(null, "Mr", "Aoi", "", "aoi123", "JP", "aoi@gmail.com", Gender.M);
		User u11 = new User(null, "Miss", "Sakura", "", "sakura123", "JP", "gorila@gmail.com", Gender.F);
		User u12 = new User(null, "Miss", "Kiro", null, "kiro123", "BR", "kiro@gmail.com", Gender.F);
		User u13 = new User(null, "Mr", "Miw", null, "miw123", "BR", "miw@gmail.com", Gender.M);
		User u14 = new User(null, "Mr", "Wrath", null, "wrath123", "BR", "wrath@gmail.com", Gender.M);
		User u15 = new User(null, "Mr", "Chisu", null, "chisu123", "BR", "chisu@gmail.com", Gender.M);
		User u16 = new User(null, "Miss", "Kyoko", null, "kyoko123", "JP", "kyoko@gmail.com", Gender.F);
		User u17 = new User(null, "Miss", "Petra", null, "petra123", "JP", "petra@gmail.com", Gender.F);
		User u18 = new User(null, "Miss", "Mahina", null, "mahina123", "JP", "hina@gmail.com", Gender.F);
		User u19 = new User(null, "Miss", "Karura", null, "karura123", "BR", "karu@gmail.com", Gender.F);
		User u20 = new User(null, "Mr", "Rohn", null, "rohn123", "UK", "rohn@gmail.com", Gender.M);

		Post p1 = new Post(null, u1, "sexo", Instant.parse("2019-06-20T19:53:07Z"));
		Post p2 = new Post(null, u2, "AAAAAAAAAAA", Instant.parse("2022-06-20T23:53:07Z"));
		Post p3 = new Post(null, u1, "BBBBBBBBBBB", Instant.parse("2022-06-20T23:53:07Z"));
		Post p4 = new Post(null, u2, "CCCCCCCCCCC", Instant.parse("2022-06-20T23:53:07Z"));

		u1.getPosts().add(p1);
		u2.getPosts().add(p2);
		u2.getPosts().add(p3);
		u1.getPosts().add(p4);

		Commentary c1 = new Commentary(null, u4, p1, "gosto também", null, 69);
		Commentary c2 = new Commentary(null, u5, p1, "yes", null, 65);
		Commentary c3 = new Commentary(null, u6, p2, "no", null, 44);
		Commentary c4 = new Commentary(null, u7, p2, "maybe", null, 700);
		Commentary c5 = new Commentary(null, u1, p1, "gosto também", null, 69);

		userRepository.saveAll(Arrays.asList(u1, u2, u3, u4, u5, u6, u7, u8, u9, u10, u11, u12, u13, u14, u15, u16, u17,
				u18, u19, u20));
		postRepository.saveAll(Arrays.asList(p1, p2, p3, p4));
		commentaryRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5));

	}

}