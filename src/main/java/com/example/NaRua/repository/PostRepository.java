package com.example.NaRua.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.NaRua.model.PostModel;
import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<PostModel,Long>{ 
	List<PostModel> findByText(String text);
	List<PostModel> findByTextOrderByDateDesc(String text);
	List<PostModel> findAll();
	Optional<PostModel> findById(Long id);
	long countByText(String text);
	void deleteByText(String text);
	void deleteById(Long id);
	boolean existsByText(String text);
}
