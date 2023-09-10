package com.eazipay.eazipaytask.controllers;


import com.eazipay.eazipaytask.dto.CreateUserInput;
import com.eazipay.eazipaytask.dto.LoginInput;
import com.eazipay.eazipaytask.dto.LoginOutput;
import com.eazipay.eazipaytask.models.AppUser;
import com.eazipay.eazipaytask.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

   @QueryMapping
   public LoginOutput logIn(@Argument LoginInput input){
       return userService.logIn(input);
   }

    @MutationMapping
    public AppUser createUser(@Argument CreateUserInput input) {
        return userService.createUser(input);
    }
}
