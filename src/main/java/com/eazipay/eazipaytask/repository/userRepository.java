package com.eazipay.eazipaytask.repository;

import com.eazipay.eazipaytask.models.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface userRepository extends MongoRepository<User, Id> {
}
