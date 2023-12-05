package com.project.service;

import java.util.List;

import com.project.entity.Address;

public interface AddressService {

	Address addAddressForUser(Integer userId, Address address);
	List<Address> getAddressesByUserId(Integer userId);
	void deleteAddress(Integer userId);
    Address updateAddressForUser(Integer userId, Integer id, Address updatedAddress);
	

	

}
