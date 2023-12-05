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

import com.project.entity.Address;
import com.project.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {
           @Autowired
           public AddressService addressService;
           
           @PostMapping("/{userId}/addresses")
           @PreAuthorize("hasRole('ROLE_USER')")
           public ResponseEntity<Address> addAddressForUser(@PathVariable Integer userId, @RequestBody Address address) {
               Address savedAddress = addressService.addAddressForUser(userId, address);
               
               if (savedAddress == null) {
                   return ResponseEntity.badRequest().build();
               }
               
               return ResponseEntity.ok(savedAddress);
           }
           @GetMapping("/{userId}/addresses")
           @PreAuthorize("hasRole('ROLE_USER')")
           public ResponseEntity<List<Address>> getAddressesByUserId(@PathVariable Integer userId) {
               List<Address> addresses = addressService.getAddressesByUserId(userId);
               
               if (addresses.isEmpty()) {
                   return ResponseEntity.noContent().build();
               }
               
               return ResponseEntity.ok(addresses);
           }

     @DeleteMapping("/{userId}/addresses")
     @PreAuthorize("hasRole('ROLE_USER')")
     public void deleteAddress(@PathVariable Integer userId) {
    	 addressService.deleteAddress(userId);
     }
     @PutMapping("/{userId}/addresses/{id}")
     @PreAuthorize("hasRole('ROLE_USER')")
     public ResponseEntity<Address> updateAddressForUser(
             @PathVariable Integer userId,
             @PathVariable Integer id,
             @RequestBody Address updatedAddress) {

         Address address = addressService.updateAddressForUser(userId, id, updatedAddress);

         if (address == null) {
             return ResponseEntity.notFound().build();
         }

         return ResponseEntity.ok(address);
     }
	}
