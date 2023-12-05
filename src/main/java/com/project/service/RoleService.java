package com.project.service;

import java.util.List;

import com.project.entity.Role;


public interface RoleService {
    
	
	public List<Role> getAll();
	public List<Role> getAllCommunities();

	public List<Role> getAllByCommunity();
}
