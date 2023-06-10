package com.example.NaRua.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.NaRua.model.UserModel;
import com.example.NaRua.service.UserService;
import com.example.NaRua.Exception.NotFoundEntityException;


@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value="/create", method=RequestMethod.POST)
	public ResponseEntity<UserModel> createUser
			(@RequestBody UserModel userModel) {
		return ResponseEntity.status(HttpStatus.OK).
				body(userService.createUser(userModel));
	}

	@RequestMapping(value="/create", method={RequestMethod.GET, RequestMethod.PUT})
	public ResponseEntity<String> handleUnsupportedMethods() {
		String errorMessage = "Método de requisição não permitido, por favor use o POST!";
		return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(errorMessage);
	}

	@RequestMapping(value="/list", method=RequestMethod.GET)
	public ResponseEntity<List<UserModel>> readUser() {
		return ResponseEntity.status(HttpStatus.OK)
				.body(userService.getAllUser());
	}

	@RequestMapping(value="/list", method={RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
	public ResponseEntity<String> handleUnsupportedMethodsForReadUser() {
		String errorMessage = "Método de requisição não permitido, por favor use o GET!";
		return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(errorMessage);
	}

	@RequestMapping(value="/update/{userUsername}", method=RequestMethod.PUT)
	public ResponseEntity<UserModel> updateCliente(
			@PathVariable(value = "userUsername") String username,
			@RequestBody UserModel userModel) throws NotFoundEntityException {
		return ResponseEntity.status(HttpStatus.OK)
				.body(userService.updateUser(username, userModel));
	}

	@RequestMapping(value="/update/{userUsername}", method={RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
	public ResponseEntity<String> handleUnsupportedMethodsForUpdateCliente() {
		String errorMessage = "Método de requisição não permitido, por favor use o PUT!";
		return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(errorMessage);
	}

	@RequestMapping(value="/delete/{userId}", method=RequestMethod.DELETE)
	public ResponseEntity<UserModel> deleteUser(
			@PathVariable(value = "userId") Long id) {
		userService.deleteUser(id);
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}

	@RequestMapping(value="/delete/{userId}", method={RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
	public ResponseEntity<String> handleUnsupportedMethodsForDeleteUser() {
		String errorMessage = "Método de requisição não permitido, por favor use o DELETE!";
		return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(errorMessage);
	}
}
