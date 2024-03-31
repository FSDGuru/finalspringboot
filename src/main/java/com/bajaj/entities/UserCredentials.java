package com.bajaj.entities;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="credentials")
public class UserCredentials {
    @Id
    public long id;
    private  String loginId;

    private String password;

}
