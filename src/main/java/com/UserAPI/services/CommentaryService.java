package com.UserAPI.services;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.hibernate.annotations.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.UserAPI.Model.Commentary;
import com.UserAPI.repositories.CommentaryRepository;

@Service
public class CommentaryService {

	@Autowired
	private CommentaryRepository commentaryRepository;

	public List<Commentary> findAll() {
		List<Commentary> comments = commentaryRepository.findAll();
		return comments;
	}

	public Commentary findById(Long id) {
		Optional<Commentary> comments = commentaryRepository.findById(id);
		return comments.get();
	}

	public Commentary findMostLiked() {
		List<Commentary> comments = commentaryRepository.findAll();
		Commentary comment = comments.stream().max((x, y) -> x.getLikeCount() - y.getLikeCount()).get();
		return comment;
	}

	public Commentary giveLike(Long id) {
		Commentary commentary = commentaryRepository.findById(id).get();
		commentary.setLikeCount(commentary.incrementLike());
		return commentary;

	}

	public Commentary save(Commentary commentary) {
		Commentary c = new Commentary(commentary);
		commentaryRepository.save(c);
		return c;

	}
}
