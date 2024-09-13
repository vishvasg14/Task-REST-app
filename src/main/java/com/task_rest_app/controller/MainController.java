package com.task_rest_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task_rest_app.dto.StudentReqDto;
import com.task_rest_app.dto.StudentResDto;
import com.task_rest_app.entity.User;
import com.task_rest_app.services.UserService;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/home")
public class MainController {

	@Autowired
	private UserService userService;

	@PostMapping("user")
	public String addUser(@RequestBody StudentReqDto studentReqDto) {
		return userService.addNewUser(studentReqDto);
	}

	@GetMapping("user/{id}")
	public StudentResDto getAUser(@PathVariable int id) {
		return userService.getUser(id);
	}
	
	@GetMapping("user")
	public List<User> getAllUser() {
		return userService.getUserList();
	}

	@PutMapping("updateuser/{id}")
	public ResponseEntity<StudentResDto> updateOneUser(@PathVariable int id,
			@RequestBody StudentReqDto studentReqDto) throws Exception {
		return userService.updateUser(id, studentReqDto);
	}

}
