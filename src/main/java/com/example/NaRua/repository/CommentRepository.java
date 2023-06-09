package com.example.NaRua.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.NaRua.model.CommentModel;
import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<CommentModel,Long>{
	List<CommentModel> findByTextOrderByDateDesc(String text);
	List<CommentModel> findByTextOrderByDateAsc(String text);
	List<CommentModel> findAll();
	Optional<CommentModel> findById(Long id);
	CommentModel findByText(String text);
	long countByText(String text);
	void deleteByText(String text);
	void deleteById(Long id);
	boolean existsByText(String text);
}
