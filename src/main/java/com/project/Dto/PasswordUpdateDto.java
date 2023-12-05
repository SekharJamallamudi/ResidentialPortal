package com.project.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PasswordUpdateDto {
  
	private String oldPassword;
    private String newPassword;
    private String confirmPassword;
}
