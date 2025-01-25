package com.vector.authorbookrest2025.dto;

import com.vector.authorbookrest2025.entity.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveUserRequest {

    private String name;
    private String surname;
    private String email;
    private String password;
    private UserType userType;

}