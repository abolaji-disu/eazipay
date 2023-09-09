package com.eazipay.eazipaytask.service;

import com.eazipay.eazipaytask.dto.CreateUserInput;
import com.eazipay.eazipaytask.dto.LoginInput;
import com.eazipay.eazipaytask.dto.LoginOutput;
import com.eazipay.eazipaytask.models.AppUser;

public interface UserService {
    AppUser createUser (CreateUserInput req);
    LoginOutput logIn (LoginInput req);
}
