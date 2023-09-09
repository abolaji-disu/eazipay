package com.eazipay.eazipaytask.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateUserInput {

    @NotEmpty(message = "Field cannot be null or empty")
    private String firstName;

    @NotEmpty(message = "Field cannot be null or empty")
    private String lastName;

    @NotEmpty(message = "Field cannot be null or empty")
    private String email;

    @NotEmpty(message = "Field cannot be null or empty")
    private String phoneNumber;

    @NotEmpty(message = "Field cannot be null or empty")
    private String password;
}
