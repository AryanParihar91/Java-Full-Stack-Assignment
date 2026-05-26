package com.wipro.ecom.app.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
public class CustomersDto {


	@Min(value = 1, message = "Customer ID must be greater than 0")
    private int cid;

    @NotBlank(message = "Customer name is required")
    @Size(min = 3, max = 50, message = "Csustomer name must be between 3 and 50 characters")
    private String cname;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Address is required")
    private String address;	
}
