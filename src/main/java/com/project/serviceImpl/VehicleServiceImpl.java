package com.project.serviceImpl;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.project.entity.Vehicle;
import com.project.repository.VehicleRepository;
import com.project.service.VehicleService;
@Service
public class VehicleServiceImpl implements VehicleService {
	@Autowired
    private Cloudinary cloudinary; // Inject Cloudinary instance
	
	@Autowired
	public VehicleRepository vehicleRepository;
	 // CRUD operations
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public Vehicle getVehicleById(Long id) {
        return vehicleRepository.findById(id).orElse(null);
    }

    
    public void deleteVehicle(Long id) {
        vehicleRepository.deleteById(id);
    }
    @Override
    public Vehicle uploadVehicle(Vehicle vehicle, MultipartFile file) throws IOException {
        // Upload image to Cloudinary
        Map<?, ?> uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
        
        // Get the URL of the uploaded image from Cloudinary response
        String imageUrl = (String) uploadResult.get("url");
        vehicle.setImageUrl(imageUrl);
        
        // Save vehicle details (including image URL) to the database
        return vehicleRepository.save(vehicle);
    }

	
}
