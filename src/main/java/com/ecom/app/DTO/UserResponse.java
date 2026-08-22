package com.ecom.app.DTO;

import com.ecom.app.Model.UserRole;
import lombok.Data;

@Data
public class UserResponse {
    public String id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNo;
    private UserRole userRole;
    private AddressDTO address;
}
