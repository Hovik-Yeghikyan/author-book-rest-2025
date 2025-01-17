package com.vector.authorbookrest2025.dto;

import com.vector.authorbookrest2025.entity.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveAuthorRequest {
    private String name;
    private String surname;
    private String phone;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirthday;
    private Gender gender;
}
