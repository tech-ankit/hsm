package com.hms.repository;

import com.hms.entity.AppUser;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AppUserRepository extends MongoRepository<AppUser,String> {
    Optional<AppUser> findByEmail(String email);

    Optional<AppUser> findByUsername(String username);
}
