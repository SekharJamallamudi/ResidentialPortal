package com.project.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    
	 Optional<User> findByEmail(String username);
	 @Query("SELECT u FROM User u JOIN u.roles r WHERE r.roleName = :roleName")
	List<User> findByRolesRoleName(@Param("roleName")String roleName);
	
	
	
	
	

	//List<User> findByRoleName(String roleName);

	
    
	
	
}
