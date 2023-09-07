package com.eazipay.eazipaytask.controllers;


import com.eazipay.eazipaytask.dto.CreateUserInput;
import com.eazipay.eazipaytask.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @MutationMapping
    public String createUser( @Argument CreateUserInput input) {
        return userService.createUser(input);
    }
}
