package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.project.entity.Technicians;

public interface TechnicianRepository extends JpaRepository<Technicians, Long> {

}