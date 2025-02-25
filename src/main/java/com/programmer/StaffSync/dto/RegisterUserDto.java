package com.programmer.StaffSync.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserDto {
    private String email;
    private String password;
    
    public RegisterUserDto(CompanyDto companyDto) {
        this.email = companyDto.getEmail();
        this.password = companyDto.getPassword();
    }
}