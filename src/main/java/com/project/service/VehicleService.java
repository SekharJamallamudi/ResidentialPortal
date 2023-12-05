package com.project.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.project.entity.Vehicle;

public interface VehicleService {

	List<Vehicle> getAllVehicles();

	Vehicle getVehicleById(Long id);

	void deleteVehicle(Long id);

	Vehicle uploadVehicle(Vehicle vehicle, MultipartFile file) throws IOException;

}
