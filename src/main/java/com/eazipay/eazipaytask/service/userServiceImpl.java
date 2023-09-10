package com.eazipay.eazipaytask.service;

import com.eazipay.eazipaytask.dto.CreateUserInput;
import com.eazipay.eazipaytask.dto.LoginInput;
import com.eazipay.eazipaytask.dto.LoginOutput;
import com.eazipay.eazipaytask.exception.AppUserException;
import com.eazipay.eazipaytask.models.AppUser;
import com.eazipay.eazipaytask.repository.AppUserRepository;
import com.eazipay.eazipaytask.security.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class userServiceImpl implements UserService {

    private final AppUserRepository userRepository;
    private final JwtService jwtService;

    @Override
    public AppUser createUser(CreateUserInput createUserInput){

        if (userRepository.existsByEmail(createUserInput.getEmail()))
            throw new AppUserException("User Already Exist");

        String encodedPassword = new BCryptPasswordEncoder().encode(createUserInput.getPassword());

     return userRepository.save(AppUser.builder()
                        .email(createUserInput.getEmail())
                        .firstName(createUserInput.getFirstName())
                        .lastName(createUserInput.getLastName())
                        .phoneNumber(createUserInput.getPhoneNumber())
                        .password(encodedPassword)
                .build());
    }

    @Override
    public LoginOutput logIn(LoginInput req) {

        String token = null;
        Optional<AppUser> appUser = userRepository.findUserByEmail(req.getEmail());

        if (appUser.isEmpty()) throw new AppUserException("User does not Exist");
        AppUser user = appUser.get();

        String userPassword  = user.getPassword();
        boolean isUserCredentialsValid = isUserCredentialsValid(req, user, userPassword);

        token = jwtService.generateToken(req.getEmail());

        if (isUserCredentialsValid) token = jwtService.generateToken(req.getEmail());

        return LoginOutput.builder()
                .token(token)
                .message("Successful")
                .build();



    }

    private  boolean isUserCredentialsValid(LoginInput req, AppUser user, String userPassword) {
      return new BCryptPasswordEncoder().encode(req.getPassword()).equals(userPassword) && user.getEmail().equals(req.getEmail());

    }
}
