package com.middle.main.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.middle.main.bo.User;


public interface UserRepos extends JpaRepository<User,Long>{
	
	
	@Query(value = "select u.uid,"
			+ "u.username,"
			+ "u.password,"
			+ "u.status,"
			+ "u.up_date from User u where u.username=:username and u.password=:password and status='Y'")
	List<Object[]> findUser(@Param("username") String username,@Param("password") String password);
}
