package com.hms.service;

import com.hms.entity.AppUser;
import com.hms.repository.AppUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AppUserService {

    private AppUserRepository appUserRepository;


    public ResponseEntity<?> createUser(AppUser appUser) {
        Optional<AppUser> opEmail  = appUserRepository.findByEmail(appUser.getEmail());
        if (opEmail.isPresent()){
            return new ResponseEntity<>("Email already Exists" , HttpStatus.INTERNAL_SERVER_ERROR);
        }

        Optional<AppUser> opUsername = appUserRepository.findByUsername(appUser.getUsername());
        if (opUsername.isPresent()){
            return new ResponseEntity<>("Username alrady Exists" , HttpStatus.INTERNAL_SERVER_ERROR);
        }

        String pwd = BCrypt.hashpw(appUser.getPassword(), BCrypt.gensalt(4));
        appUser.setPassword(pwd);
        AppUser user = appUserRepository.save(appUser);
        return new ResponseEntity<>(user ,HttpStatus.CREATED);
    }
}
