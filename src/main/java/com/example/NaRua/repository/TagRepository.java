package com.example.NaRua.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.NaRua.model.TagModel;
import java.util.List;
import java.util.Optional;

@Repository
public interface TagRepository extends JpaRepository<TagModel,Long>{
	List<TagModel> findByCategory(String category);
	List<TagModel> findByNameAndCategory(String name, String category);
	List<TagModel> findAll();
	Optional<TagModel> findById(Long id);
	TagModel findByName(String name);
	long countByName(String name);
	void deleteByName(String name);
	void deleteByCategory(String category);
	void deleteById(Long id);
	boolean existsByName(String name);
}
