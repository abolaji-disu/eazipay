package com.eazipay.eazipaytask.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
public class CreateUserInput {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
}
