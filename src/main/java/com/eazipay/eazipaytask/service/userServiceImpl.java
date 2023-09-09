package com.eazipay.eazipaytask.service;

import com.eazipay.eazipaytask.dto.CreateUserInput;
import com.eazipay.eazipaytask.dto.LoginInput;
import com.eazipay.eazipaytask.dto.LoginOutput;
import com.eazipay.eazipaytask.models.AppUser;
import com.eazipay.eazipaytask.repository.AppUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class userServiceImpl implements UserService {

    private final AppUserRepository userRepository;

    @Override
    public AppUser createUser(CreateUserInput createUserInput){

        if (userRepository.existsByEmail(createUserInput.getEmail())){
            System.out.println("user exist in db");
        }
     return userRepository.save(AppUser.builder()
                        .email(createUserInput.getEmail())
                        .firstName(createUserInput.getFirstName())
                        .lastName(createUserInput.getLastName())
                        .phoneNumber(createUserInput.getPhoneNumber())
                        .password(createUserInput.getPassword())
                .build());
    }

    @Override
    public LoginOutput logIn(LoginInput req) {
        return null;
    }
}
