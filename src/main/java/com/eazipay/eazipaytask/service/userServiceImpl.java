package com.eazipay.eazipaytask.service;

import com.eazipay.eazipaytask.dto.CreateUserInput;
import com.eazipay.eazipaytask.models.User;
import com.eazipay.eazipaytask.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class userServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User createUser(CreateUserInput createUserInput){

        if (userRepository.existsByEmail(createUserInput.getEmail())){
            System.out.println("user exist in db");
        }

     User newUser =  userRepository.save(User.builder()
                        .email(createUserInput.getEmail())
                        .firstName(createUserInput.getFirstName())
                        .lastName(createUserInput.getLastName())
                        .phoneNumber(createUserInput.getPhoneNumber())
                        .password(createUserInput.getPassword())
                .build());

        log.info("logging new user info");
        log.info(newUser.toString());

        return newUser;

    }
}
