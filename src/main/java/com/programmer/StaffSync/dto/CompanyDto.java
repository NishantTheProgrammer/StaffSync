package com.programmer.StaffSync.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDto {
    private Integer id;
    private Integer userId;
    private String name;
    private String logo;
    private String address;
    private String pan;
    private String email;
    private String password;
}
