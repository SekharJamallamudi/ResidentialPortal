package com.project.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CurrentTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.project.entity.enums.Technician;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Data
@Entity
public class Technicians {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
     private Long id;
	 private String name;
	 private String email;
	 private double phNo;
	 private int floor;
     private String Description;
     @Enumerated(EnumType.STRING)
     private Technician technicians;
     @CurrentTimestamp
     private LocalDateTime createDate;
     @UpdateTimestamp
     private LocalDateTime updateDate;
     
     
}