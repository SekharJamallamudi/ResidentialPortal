package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.Role;
import com.project.service.RoleService;
@RequestMapping("/user")
@RestController

public class RoleController {
     @Autowired
     private RoleService service;
	
	 // ADMIN CAN GET THE ALL USERS DATA
	
		@GetMapping("/getAll")
		@PreAuthorize("hasRole('ROLE_ADMIN')")
		public List<Role> getAll()
		{
			
			return service.getAll();
		}
		
		// ADMIN CAN GET ALL THE COMMUNITIES DATA
		
		@GetMapping("/communities")
		@PreAuthorize("hasRole('ROLE_ADMIN')")
	    public List<Role> getAllCommunities() {
	        return service.getAllCommunities();
	    }
		
		
		// COMMUNITY CAN GET THE ALL USERS DATA
		
	    @GetMapping("/getAllUsers")
	    @PreAuthorize("hasRole('ROLE_COMMUNITY')")
	    public List<Role>getAllByCommunity()
	    {
	    	return service.getAllByCommunity();
	    }
}
