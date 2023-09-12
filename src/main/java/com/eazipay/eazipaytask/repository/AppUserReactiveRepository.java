package com.eazipay.eazipaytask.repository;

import com.eazipay.eazipaytask.models.AppUser;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface AppUserReactiveRepository extends ReactiveMongoRepository<AppUser, String> {
}