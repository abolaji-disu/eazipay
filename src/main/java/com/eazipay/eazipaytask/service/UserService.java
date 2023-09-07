package com.eazipay.eazipaytask.service;

import com.eazipay.eazipaytask.dto.CreateUserInput;
import com.eazipay.eazipaytask.models.User;

public interface UserService {
    User createUser (CreateUserInput req);
}
