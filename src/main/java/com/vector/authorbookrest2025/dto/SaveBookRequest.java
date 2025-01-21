package com.vector.authorbookrest2025.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveBookRequest {

    @NotEmpty(message = "Title cant be empty")
    @Size(min = 2, message = "Title's length should be > 2")
    private String title;
    @Min(value = 1, message = "Price should be >= 1")
    private double price;
    @Min(value = 1, message = "qty should be >=1")
    private int qty;
    private int authorId;
}
