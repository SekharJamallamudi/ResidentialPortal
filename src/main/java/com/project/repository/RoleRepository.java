package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.Role;


public interface RoleRepository extends JpaRepository<Role, Long>{
	 List<Role> findByRoleName(String roleName);

	

	

	
}
