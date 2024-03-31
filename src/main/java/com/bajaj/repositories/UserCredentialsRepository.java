package com.bajaj.repositories;

import com.bajaj.entities.UserCredentials;
import com.bajaj.entities.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UserCredentialsRepository  extends MongoRepository<UserCredentials,Long>  {


    List<UserEntity> findByLoginIdAndPassword(String loginId,String password);
}
