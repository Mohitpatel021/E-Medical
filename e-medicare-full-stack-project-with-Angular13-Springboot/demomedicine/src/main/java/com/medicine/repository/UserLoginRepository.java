package com.medicine.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.medicine.model.UserLogin;

public interface UserLoginRepository extends JpaRepository<UserLogin, String>{
	@Query("SELECT ul FROM UserLogin ul WHERE ul.userid =?1 and ul.password=?2")
			public UserLogin validateUserLogin(Long long1,String password);





	public Optional<UserLogin> findByPassword(String string);



	
	
	
}