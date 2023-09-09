package com.eazipay.eazipaytask.repository;

import com.eazipay.eazipaytask.models.AppUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepository extends MongoRepository<AppUser, String> {


    boolean existsByEmail(String s);

    Optional<AppUser> findUserByEmail(String username);
}
