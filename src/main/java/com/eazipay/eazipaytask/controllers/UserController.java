package com.eazipay.eazipaytask.controllers;


import com.eazipay.eazipaytask.dto.CreateUserInput;
import com.eazipay.eazipaytask.models.AppUser;
import com.eazipay.eazipaytask.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/users/")
@Slf4j
public class UserController {

    private final UserService userService;

    @GetMapping("test")
    public ResponseEntity<String> sayHello(){
        log.info("saying hello");
        return new ResponseEntity<String>("Hello World", HttpStatus.OK);
    }

    @MutationMapping
    public AppUser createUser(@Argument CreateUserInput input) {
        return userService.createUser(input);
    }
}
