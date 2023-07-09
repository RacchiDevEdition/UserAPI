package com.UserAPI.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.UserAPI.Model.Commentary;
import com.UserAPI.Model.Post;
import com.UserAPI.Model.PostCommentary;
import com.UserAPI.Model.User;
import com.UserAPI.Model.UserPost;
import com.UserAPI.enums.Gender;
import com.UserAPI.repositories.CommentaryRepository;
import com.UserAPI.repositories.PostCommentaryRepository;
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

	@Autowired
	private CommentaryRepository commentaryRepository;
	
	@Autowired
	private PostCommentaryRepository postCommentaryRepository;

	@Override
	public void run(String... args) throws Exception {

		User u1 = new User(null, "Miss", "Jennie", "Nichols",
				"48df5229235ada28389b91e60a935e4f9b73eb4bdb855ef9258a1751f10bdc5d", "USA", "jennie.nichols@example.com",
				Gender.F);
		
		User u2 = new User(null, "Mr", "Comedor de Casadas", null, "1231241235125123516", "BR", "aaaaaa@gmail.com",
				Gender.M);
		
	
		Post p1 = new Post(null, null, "sexo", Instant.parse("2019-06-20T19:53:07Z"));

		Post p2 = new Post(null, null, "AAAAAAAAAAA", Instant.parse("2022-06-20T23:53:07Z"));
		Post p3 = new Post(null, null, "BBBBBBBBBBB", Instant.parse("2022-06-20T23:53:07Z"));
		Post p4 = new Post(null, null, "CCCCCCCCCCC", Instant.parse("2022-06-20T23:53:07Z"));


		Commentary c1 = new Commentary(null, u1, p1, "gosto também", 69);
		Commentary c2 = new Commentary (null, u2, p1, "yes", 65);
		Commentary c3 = new Commentary (null, u2, p2, "no", 44);
		Commentary c4 = new Commentary (null, u1, p2, "maybe", 31);



		u1.getPosts().add(p1);
		u1.getPosts().add(p2);
		u1.getPosts().add(p3);
		u2.getPosts().add(p4);
		
		p1.setCreator(u1);
		p2.setCreator(u2);
		p3.setCreator(u2);
		p4.setCreator(u1);

		UserPost up1 = new UserPost(p1, u1);
		UserPost up2 = new UserPost(p2, u1);
		UserPost up3 = new UserPost(p3, u2);
		UserPost up4 = new UserPost(p4, u2);
		
	/*	PostCommentary pc1 =  new PostCommentary(u1, p1, c1);
		PostCommentary pc2 =  new PostCommentary(u1, p2, c4);
		PostCommentary pc3 = new PostCommentary(u2, p1, c2);
		PostCommentary pc4 = new PostCommentary(u2, p2, c3);
*/
		userRepository.saveAll(Arrays.asList(u1, u2));
		postRepository.saveAll(Arrays.asList(p1, p2, p3, p4));
		userPostRepository.saveAll(Arrays.asList(up1, up2, up3, up4));
		commentaryRepository.saveAll(Arrays.asList(c1, c2));
	//	postCommentaryRepository.saveAll(Arrays.asList(pc1, pc2, pc3,pc4));
		
		System.out.println(u1);
		System.out.println(p1);
		System.out.println(up1);
		System.out.println(c1);

	}

}