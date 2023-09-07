package com.eazipay.eazipaytask.service;

import com.eazipay.eazipaytask.dto.CreateUserInput;
import com.eazipay.eazipaytask.models.User;
import com.eazipay.eazipaytask.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class userServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public String createUser(CreateUserInput createUserInput){

        if (userRepository.existsByEmail(createUserInput.getEmail())){
            System.out.println("user exist in db");
        }

        userRepository.save(User.builder()
                        .email(createUserInput.getEmail())
                        .firstName(createUserInput.getFirstName())
                        .lastName(createUserInput.getLastName())
                        .phoneNumber(createUserInput.getPhoneNumber())
                        .password(createUserInput.getPassword())
                .build());

        return "User Succesfully created";

    }
}
