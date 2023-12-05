package com.project.entity;

import com.project.entity.enums.AddressType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "addresses",uniqueConstraints = {
        @UniqueConstraint(columnNames = {"user_id","addressType"})
    })
public class Address {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;
        private Integer pinCode;
	    private String street;
	    private String State;
	    private String city;
	    private String country;
	    @Enumerated(EnumType.STRING)
	    private AddressType addressType;
	    @Column(name = "user_id") // Join column in the Address table referencing user_id
	    private Integer userId; // This column stores the reference to the User table
	    
		
}
