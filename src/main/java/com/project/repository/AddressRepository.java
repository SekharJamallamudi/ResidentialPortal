package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.Address;
@Repository
public interface AddressRepository extends JpaRepository<Address,Integer >{

	List<Address> findByUserId(Integer userId);

	

	

}
