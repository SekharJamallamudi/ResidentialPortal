package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.Technicians;
import com.project.service.TechnicianService;
@RequestMapping("/user")
@RestController
public class TechnicianController {
	
	       @Autowired
	       private TechnicianService technicianService;
	  //USER CAN POST THE TECHNICIAN
	      @PostMapping("/saveTech")
	      @PreAuthorize("hasRole('ROLE_USER')")
         public Technicians  addTechnician(@RequestBody Technicians technician)
         {
			return technicianService.addTechnician(technician);
        	 
         }
	  //COMMUNITY CAN GET THE ALL TECHNICIANS
	      @GetMapping("/AllTech")
	      @PreAuthorize("hasRole('ROLE_COMMUNITY')")
	      public List<Technicians> allTech()
	      {
	    	  return technicianService.allTech();
	      }
}