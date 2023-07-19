package com.UserAPI.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.UserAPI.Model.Commentary;
import com.UserAPI.dto.DtoCommentary;
import com.UserAPI.repositories.CommentaryRepository;
import org.modelmapper.ModelMapper;


@Service
public class CommentaryService {

	@Autowired
	private CommentaryRepository commentaryRepository;

	ModelMapper mapper = new ModelMapper();

	public List<DtoCommentary> findAll() {
		List<Commentary> comments = commentaryRepository.findAll();
		List<DtoCommentary> findAll = comments.stream().map(x -> new DtoCommentary(x)).toList();
		return findAll;

	}

	public DtoCommentary findById(Long id) {
		Commentary comment = commentaryRepository.findById(id).get();
		DtoCommentary findById = new DtoCommentary(comment);
		return findById;
	}

	public DtoCommentary findMostLiked() {
		List<Commentary> comments = commentaryRepository.findAll();
		List<DtoCommentary> dto = comments.stream().map(x -> new DtoCommentary(x)).toList();
		DtoCommentary mostLiked = dto.stream().max((x, y) -> x.getLikeCount() - y.getLikeCount()).get();
		return mostLiked;
	}

	public DtoCommentary giveLike(Long id) {
		Commentary commentary = commentaryRepository.findById(id).get();
		commentary.setLikeCount(commentary.incrementLike());
		commentaryRepository.save(commentary);
		DtoCommentary liked = new DtoCommentary(commentary);
		return liked;

	}

	public DtoCommentary save(Commentary comment) {
		Commentary c = commentaryRepository.save(comment);
		DtoCommentary newComment = new DtoCommentary(c);
		return newComment;

	}
	


}
