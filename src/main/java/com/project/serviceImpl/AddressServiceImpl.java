package com.project.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.Address;
import com.project.repository.AddressRepository;
import com.project.service.AddressService;
@Service
public class AddressServiceImpl implements AddressService {
       @Autowired
       public AddressRepository addressRepository;
       
       
       public Address addAddressForUser(Integer userId, Address address) {
           address.setUserId(userId); // Set the userId for the address
           // Perform any other necessary validations or operations
           
           return addressRepository.save(address);
       }
       
       @Override
   	public List<Address> getAddressesByUserId(Integer userId) {
    	   return addressRepository.findByUserId(userId);
   	}

	@Override
	public void deleteAddress(Integer userId) {
		addressRepository.deleteById(userId);
	}
	public Address updateAddressForUser(Integer userId, Integer id, Address updatedAddress) {
        Address existingAddress = addressRepository.findById(id).orElse(null);

        if (existingAddress != null && existingAddress.getUserId().equals(userId)) {
            // Update the existing address fields
        	existingAddress.setPinCode(updatedAddress.getPinCode());
        	existingAddress.setState(updatedAddress.getState());
        	existingAddress.setCountry(updatedAddress.getCountry());
        	existingAddress.setStreet(updatedAddress.getStreet());
            existingAddress.setCity(updatedAddress.getCity());
            // Update other fields as needed

            return addressRepository.save(existingAddress);
        }

        return null; // If address or user ID doesn't match, return null or handle accordingly
    }

	
}
