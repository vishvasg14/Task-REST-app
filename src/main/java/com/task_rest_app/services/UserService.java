package com.task_rest_app.services;

import org.springframework.beans.factory.annotation.Autowired;
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
		User checkUser= userRepository.findUserByEmail(studentReqDto.getEmail());
		if(checkUser!=null) {
			return "user is present!!!";
		}
		User u=new User();
		u.setFname(studentReqDto.getFname());
		u.setLname(studentReqDto.getLname());
		u.setEmail(studentReqDto.getEmail());
		userRepository.save(u);
		return "new User Added";
	}
	
	public StudentResDto getUser(int id) {
		StudentResDto profile=userRepository.getOneuser(id);
		return new StudentResDto(profile.getId(), profile.getFname(), profile.getLname(), profile.getEmail());
	}

}
