package com.project.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.Technicians;
import com.project.repository.TechnicianRepository;
import com.project.service.TechnicianService;
@Service
public class TechnicianServiceImpl implements TechnicianService {
        
	   @Autowired
	   private TechnicianRepository technicianRepository;

	@Override
	public Technicians addTechnician(Technicians technician) {
		// TODO Auto-generated method stub
		return technicianRepository.save(technician);
	}

	@Override
	public List<Technicians> allTech() {
		// TODO Auto-generated method stub
		return technicianRepository.findAll();
	}
	

}
