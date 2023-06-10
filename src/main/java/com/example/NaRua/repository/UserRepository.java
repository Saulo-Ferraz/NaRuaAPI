package com.example.NaRua.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.NaRua.model.UserModel;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
	// Consultas predefinidas

	List<UserModel> findByUsernameAndEmail(String username, String email);
	List<UserModel> findByUsernameLike(String username);
	List<UserModel> findByUsernameNotLike(String username);
	List<UserModel> findByEmailLike(String email);
	List<UserModel> findByEmailNotLike(String email);
	List<UserModel> findAll();
	Optional<UserModel> findById(Long id);
	UserModel findByUsername(String username);
	long countByUsername(String username);
	void deleteByEmail(String email);
	void deleteById(Long id);
	boolean existsByEmail(String email);

	@Query("SELECT u FROM UserModel u WHERE u.username LIKE %:keyword% OR u.email LIKE %:keyword%")
	List<UserModel> findByKeyword(String keyword);
}
