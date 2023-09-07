package com.eazipay.eazipaytask.repository;

import com.eazipay.eazipaytask.models.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, Id> {


    boolean existsByEmail(String s);
}
