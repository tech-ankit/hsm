package com.hms.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document( collection = "app_user")
public class AppUser {

    @Id
    private String id;
    private String username;
    private String email;
    private String password;
}
