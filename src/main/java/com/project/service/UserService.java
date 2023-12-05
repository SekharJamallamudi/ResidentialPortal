package com.project.service;

import java.util.List;

import com.project.Dto.PasswordUpdateDto;
import com.project.entity.User;
import com.project.exception.InvalidOldPasswordException;
import com.project.exception.UserNotFoundException;

public interface UserService {
// USER REGISTRATION
	String saveUser(User user);
	// ADMIN REGISTRATION	
	String addUser(User user);
	// COMMUNITY REGISTRATION
	String addCommunity(User user);
	//ADMIN CAN FETCH ALL USER DATA
    List<User> fetchAll();
    //COMMUNITY CAN FETCH ALL USER DATA
    List<User> fetchAllDataByCommunity();
    //ADMIN CAN FETCH ALL COMMUNITY DATA
    List<User> fetchAllDataByAdmin();
   //USER CAN GET THE DATA BY ID
	User findById(Integer id) throws UserNotFoundException;
   //USER CAN DELETE THE DATA BY ID
	String DeletaFlat(Integer id);
   //USER CAN UPDATE THE DATA BY ID
	public User updateUser(Integer userId, User updatedUserData); 
    //USER CAN CHANGE THE PASSWORD BY ID
	public boolean updatePassword(Integer id, PasswordUpdateDto passwordUpdateDto) throws InvalidOldPasswordException;
	
	
	
	
	

	
	
	
}
