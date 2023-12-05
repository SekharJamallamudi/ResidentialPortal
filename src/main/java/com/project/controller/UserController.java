package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.Dto.PasswordUpdateDto;
import com.project.entity.User;
import com.project.exception.InvalidOldPasswordException;
import com.project.exception.UserNotFoundException;
import com.project.service.UserService;


@RequestMapping("/user")
@RestController
public class UserController {
     @Autowired
     private UserService userService;
	
// RGISTRATION TO THE USER API   
       @PostMapping("/save")
	    public String saveUser(@RequestBody User user)
	       {
		   return userService.saveUser(user);
	        }
	
// REGISTRATION TO THE ADMIN API   
		@PostMapping("/admin")
		public String addUser(@RequestBody User user)
		{
			return userService.addUser(user);
		}
// REGISTRATION TO THE COMMUNITY API   
				@PostMapping("/community")
				public String addCommunity(@RequestBody User user)
				{
					return userService.addCommunity(user);
				}	
//GET ALL USER DATA BY ADMIN 
	@GetMapping("/AllData/{roleName}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	 public ResponseEntity<List<User>> getUsersWithUserRole() {
        List<User> users = userService.fetchAll();
        return ResponseEntity.ok(users);
    }
//GET ALL USER DATA BY COMMUNITY	
	@GetMapping("/AllData1/{roleName}")
	@PreAuthorize("hasRole('ROLE_COMMUNITY')")
	 public ResponseEntity<List<User>> getUsersDataByCommunity() {
        List<User> users = userService.fetchAllDataByCommunity();
        return ResponseEntity.ok(users);
    }
//GET ALL COMMUNITY DATA BY ADMIN
	@GetMapping("/AllData2/{roleName}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	 public ResponseEntity<List<User>> getcommunityDataByAdmin() {
        List<User> users = userService.fetchAllDataByAdmin();
        return ResponseEntity.ok(users);
    }
//USER CAN THE DATA BY ID	
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('ROLE_USER')")
	public User fetchById(@PathVariable Integer id) throws UserNotFoundException
	{
		return userService.findById(id);
	}
	
//USER CAN DELETE THE ACCOUNT
	@DeleteMapping("/{id}")
	
	public String Deleteflat(@PathVariable Integer id)
	{
		return userService.DeletaFlat(id);
	}
//USER CAN UPDATE THE DATA	
	@PutMapping("/{userId}")
	@PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<User> updateUser(
            @PathVariable Integer userId,
            @RequestBody User updatedUserData) {
        User updatedUser = userService.updateUser(userId, updatedUserData);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
	}
 //USER CAN CHANGED THE PASSWORD BASED ON ID
    @PutMapping("/update-password/{id}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<String> updatePassword(
            @PathVariable Integer id ,
            @RequestBody PasswordUpdateDto passwordUpdateDto) throws InvalidOldPasswordException {
        userService.updatePassword(id, passwordUpdateDto);
        return ResponseEntity.ok("Password updated successfully");
    }
   
    
}
