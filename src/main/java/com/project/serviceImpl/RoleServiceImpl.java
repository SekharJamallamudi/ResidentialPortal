package com.project.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.Role;
import com.project.repository.RoleRepository;
import com.project.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService{
     
	@Autowired
	private RoleRepository repository;
	
	public List<Role> getAll() {
        return repository.findByRoleName("ROLE_USER");
    }
	 public List<Role> getAllCommunities() {
	        return repository.findByRoleName("ROLE_COMMUNITY");
	    }
	@Override
	public List<Role> getAllByCommunity() {
		return repository.findByRoleName("ROLE_USER");
	}
}
