package com.UserAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.UserAPI.Model.Commentary;

public interface CommentaryRepository extends JpaRepository<Commentary, Long> {
	
	@Query(nativeQuery = true, value = """
			SELECT * FROM TB_COMMENTARY LIKE_COUNT
				""")

	Commentary giveLike(Long id);
}
