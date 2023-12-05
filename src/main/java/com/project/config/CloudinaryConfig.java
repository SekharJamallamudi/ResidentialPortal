package com.project.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;

@Configuration
public class CloudinaryConfig {
      private final String CLOUD_NAME="dzldywbrh";
      private final String API_KEY = "534571325557693";
      private final String API_SECRETE = "pt5OASffwPlSX45VZJdZ8I7b01s";
    @Bean
    public Cloudinary cloudinary() {
    	
    	Map<String,String> config =  new HashMap<>(); 
    	     config.put("cloud_name","CLOUD_NAME");
    	     config.put("api_key", "API_KEY");
    	     config.put("api_secrete", "API_SECRETE");
    	     config.put("Secure", "true");
        return new Cloudinary(config);
    }
}
