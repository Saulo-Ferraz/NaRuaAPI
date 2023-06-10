package com.example.NaRua.service;

import com.example.NaRua.Exception.UserCreationException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.NaRua.Exception.NotFoundEntityException;
import com.example.NaRua.model.UserModel;
import com.example.NaRua.repository.UserRepository;


@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<UserModel> getAllUser() {
		return userRepository.findAll();
	}

	public UserModel getUserById(Long id) throws NotFoundEntityException {
		return userRepository.findById(id)
				.orElseThrow(() -> new NotFoundEntityException("User not found"));
	}

	public List<UserModel> gerUserByUsernameAndEmail(String username, String email) {
		return userRepository.findByUsernameAndEmail(username, email);
	}

	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

	public UserModel createUser(UserModel userModel) throws UserCreationException {
		try {
			userRepository.save(userModel);
			return userModel;
		} catch (Exception e) {
			throw new UserCreationException("Não foi possível criar o usuário");
		}
	}

	public UserModel updateUser(String username, UserModel userModel) {
		UserModel existingUser = userRepository.findByUsername(username);
		existingUser.setUsername(userModel.getUsername());
		existingUser.setEmail(userModel.getEmail());

		return userRepository.save(existingUser);
	}
}
