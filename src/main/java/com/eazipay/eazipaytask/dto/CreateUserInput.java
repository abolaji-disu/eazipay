package com.eazipay.eazipaytask.dto;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class CreateUserInput {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
}
