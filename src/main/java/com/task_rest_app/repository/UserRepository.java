package com.task_rest_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.task_rest_app.dto.StudentResDto;
import com.task_rest_app.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findUserByEmail(String email);

	@Query("select new com.task_rest_app.dto.StudentResDto(u.id, u.fname, u.lname, u.email) from User as u where u.id = :id")
	StudentResDto getOneuser(@Param("id") int id);

	//need to define native query
	@Query(name = "select * from User where id=?1", nativeQuery = true)
	User findUserById(int id);
}
