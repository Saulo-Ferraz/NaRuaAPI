package com.example.NaRua.service;

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
		return userRepository.findById(id).orElseThrow(() ->
		new NotFoundEntityException("User not Found"));
	}
	
	public List<UserModel> gerUserByUsernameAndEmail(String username, String email) { // Possible Exception
		return userRepository.findByUsernameAndEmail(username, email);
	}
	
	public void deleteUser(Long id) { // Possible Exception
		userRepository.deleteById(id);
	}
	
	public UserModel createUser(UserModel userModel) {
		userRepository.save(userModel);
		return userModel;
	}
	
	public UserModel updateUser(String username, UserModel userModel) {
		UserModel existingUser = userRepository.findByUsername(username);	
		existingUser.setUsername(userModel.getUsername());
		existingUser.setEmail(userModel.getEmail());
		
		
		return userRepository.save(existingUser);
		}
}
