package com.example.NaRua.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.NaRua.model.PlaylistModel;
import java.util.List;
import java.util.Optional;

@Repository
public interface PlaylistRepository extends JpaRepository<PlaylistModel,Long>{
	List<PlaylistModel> findByNameOrderByDateDesc(String name);
	List<PlaylistModel> findAll();
	Optional<PlaylistModel> findById(Long id);
	PlaylistModel findByName(String name);
	long countByName(String name);
	void deleteByName(String name);
	void deleteById(Long id);
	boolean existsByName(String name);
}
