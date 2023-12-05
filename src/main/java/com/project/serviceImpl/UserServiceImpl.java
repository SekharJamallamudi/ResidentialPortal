package com.project.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.Dto.PasswordUpdateDto;
import com.project.entity.Role;
import com.project.entity.User;
import com.project.exception.InvalidOldPasswordException;
import com.project.exception.UserNotFoundException;
import com.project.repository.RoleRepository;
import com.project.repository.UserRepository;
import com.project.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
    private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private RoleRepository roleRepository;
	// USER REGISTRATION	
	
	boolean flag;
	public String saveUser(User user) {
List<User> userList = userRepository.findAll();

         if(null != userList) {
			
			for(User user1 : userList) {
				if(user1.getEmail().equals(user.getEmail()))
					flag = true;
				else
					flag = false;
			}
		}
		 
		if(flag) {
			return "User already exists";
		} else {
			user.setPwd(passwordEncoder.encode(user.getPwd()));
			userRepository.save(user);
			return "User Registered SuccessFully saved";
		}
               
	}
//ADMIN REGISTRATION	
	boolean flag1;
	public String addUser(User user) {
		// TODO Auto-generated method stub
List<User> userList = userRepository.findAll();
		
		if(null != userList) {
			for(User user1 : userList) {
				if(user1.getEmail().equals(user.getEmail()))
					flag1 = true;
				else
					flag1 = false;
			}
		}
		
		if(flag1) {
			return "User already exists";
		} else {
			user.setPwd(passwordEncoder.encode(user.getPwd()));
			userRepository.save(user);
			return "Admin Registered SuccessFully saved";
		}
	}
//COMMUNITY REGISTRATION	
	boolean flag2;
	@Override
	public String addCommunity(User user) {
List<User> userList = userRepository.findAll();
		
		if(null != userList) {
			for(User user1 : userList) {
				if(user1.getEmail().equals(user.getEmail()))
					flag2 = true;
				else
					flag2 = false;
			}
		}
		
		if(flag2) {
			return "User already exists";
		} else {
			user.setPwd(passwordEncoder.encode(user.getPwd()));
			userRepository.save(user);
			return "Community Registered SuccessFully saved";
		}
	}
//ADMIN CAN FETCH ALL USER DATA	
	 public List<User> fetchAll() {
	        List<Role> userRoles = roleRepository.findByRoleName("ROLE_USER");
	        // Extract user IDs with ROLE_USER
	        List<Integer> userIds = userRoles.stream().map(Role::getId).collect(Collectors.toList());
	        // Fetch users by these user IDs
	        // Assuming you have a UserRepository to fetch users by ID
	        return userRepository.findAllById(userIds);
	    }
//ADMIN CAN FETCH ALL COMMUNITY DATA
	 @Override
		public List<User> fetchAllDataByAdmin() {
		 List<Role> userRoles = roleRepository.findByRoleName("ROLE_COMMUNITY");
	        // Extract user IDs with ROLE_USER
	        List<Integer> userIds = userRoles.stream().map(Role::getId).collect(Collectors.toList());
	        // Fetch users by these user IDs
	        // Assuming you have a UserRepository to fetch users by ID
	        return userRepository.findAllById(userIds);
		}
//COMMUNITY CAN FETCH ALL USERS DATA
	 @Override
		public List<User> fetchAllDataByCommunity() {
		 List<Role> userRoles = roleRepository.findByRoleName("ROLE_USER");
	        // Extract user IDs with ROLE_USER
	        List<Integer> userIds = userRoles.stream().map(Role::getId).collect(Collectors.toList());
	        // Fetch users by these user IDs
	        // Assuming you have a UserRepository to fetch users by ID
	        return userRepository.findAllById(userIds);
	    }
//USER CAN GET THE DATA BY ID	 
	 public User findById(Integer id)throws UserNotFoundException {
	 User user =userRepository.findById(id).orElseThrow(()->new UserNotFoundException("user with  id  "+id +" is not there in database"));
	    	return user;
	}
//USER CAN DELETE THE DATA
	public String DeletaFlat(Integer id) {
		// TODO Auto-generated method stu
		 userRepository.deleteById(id);
		 return "DeleteSuccessFully...";
		
	}
//USER DATA UPDATED BY ID
	public User updateUserAndRoles(Integer userId, User updatedUserData) {
        User existingUser = userRepository.findById(userId).orElse(null);

        if (existingUser != null) {
            // Update user data
            existingUser.setFirstName(updatedUserData.getFirstName());
            existingUser.setEmail(updatedUserData.getEmail());
            // Update other user properties as needed...

            // Update roles (assuming roles are replaced entirely)
            existingUser.setRoles(updatedUserData.getRoles());

            return userRepository.save(existingUser); // Save the updated user
        }
        return null; // User with the provided ID not found
    }
// CHANGE PASSWORD BY USER	   
	@Override
	public boolean updatePassword(Integer id, PasswordUpdateDto passwordUpdateDto) throws InvalidOldPasswordException {
		// TODO Auto-generated method stub
		 User user = userRepository.findById(id).get();

	        // Check if the old password matches the current password
	        if (!passwordEncoder.matches(passwordUpdateDto.getOldPassword(), user.getPwd())) {
	            throw new InvalidOldPasswordException("Invalid old password");
	        }
	        if (!passwordUpdateDto.getNewPassword().equals(passwordUpdateDto.getConfirmPassword())) {
	        	throw new InvalidOldPasswordException("Invalid old password"); // New password and confirm password don't match
	        }

	        // Update the password
	        user.setPwd(passwordEncoder.encode(passwordUpdateDto.getNewPassword()));
	        userRepository.save(user);
			return true ;
	    }
	@Override
	public User updateUser(Integer userId, User updatedUserData) {
		// TODO Auto-generated method stub
		return null;
	}
	
	 
            }


