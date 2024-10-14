package com.hms.controller;


import com.hms.entity.AppUser;
import com.hms.service.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class AppUserController {

    private AppUserService appUserService;

    @PostMapping("/signup")
    public ResponseEntity<?> createUser(
            @RequestBody AppUser appUser
            )
    {
        return appUserService.createUser(appUser);
    }
}
