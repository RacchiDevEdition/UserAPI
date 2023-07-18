package com.UserAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.UserAPI.Model.Commentary;

public interface CommentaryRepository extends JpaRepository<Commentary, Long> {
	
	@Query(nativeQuery = true, value = """
			SELECT * FROM TB_COMMENTARY LIKE_COUNT
				""")

	Commentary giveLike(Long id);

	/*
	@Query(nativeQuery = true, value = """
			SELECT tb_commentary.id, tb_game.title, tb_game.game_year AS gameYear, tb_game.img_url AS imgUrl,
			tb_game.short_description AS shortDescription, tb_belonging.position
			FROM tb_game
			INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
			WHERE tb_belonging.list_id = :listId
			ORDER BY tb_belonging.position
				""")
	List<DtoCommentaryProjection> getCommentariesByUser(Long id);*/
}
