package com.vector.authorbookrest2025.dto;

import com.vector.authorbookrest2025.entity.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDto {

    private int id;
    private String name;
    private String surname;
    private String phone;
    private Gender gender;
}
