package com.task_rest_app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.task_rest_app.dto.StudentReqDto;
import com.task_rest_app.dto.StudentResDto;
import com.task_rest_app.entity.User;
import com.task_rest_app.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public String addNewUser(StudentReqDto studentReqDto) {
		User checkUser = userRepository.findUserByEmail(studentReqDto.getEmail());
		if (checkUser != null) {
			return "user is present!!!";
		}
		User u = new User();
		u.setFname(studentReqDto.getFname());
		u.setLname(studentReqDto.getLname());
		u.setEmail(studentReqDto.getEmail());
		userRepository.save(u);
		return "new User Added";
	}

	public StudentResDto getUser(int id) {
		StudentResDto profile = userRepository.getOneuser(id);
		return new StudentResDto(profile.getId(), profile.getFname(), profile.getLname(), profile.getEmail());
	}

	public ResponseEntity<StudentResDto> updateUser(int id, StudentReqDto studentReqDto) throws Exception {
		User checkUser = userRepository.findUserById(id);
		if (checkUser == null) {
			throw new Exception("user not present please add first");
		}
		checkUser.setFname(studentReqDto.getFname());
		checkUser.setLname(studentReqDto.getLname());
		checkUser.setEmail(studentReqDto.getEmail());
		userRepository.save(checkUser);
		StudentResDto response = new StudentResDto(checkUser.getId(), checkUser.getFname(), checkUser.getLname(),
				checkUser.getEmail());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	public List<User> getUserList() {
		List<User> allUsers = userRepository.findAll();
		return allUsers;
	}

}
