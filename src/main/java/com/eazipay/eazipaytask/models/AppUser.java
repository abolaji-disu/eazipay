package com.eazipay.eazipaytask.models;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document
@Builder
public class AppUser {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
    private Role role = Role.USER;
}
