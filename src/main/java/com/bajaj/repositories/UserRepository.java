package com.bajaj.repositories;

import com.bajaj.entities.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UserRepository extends MongoRepository<UserEntity,Long> {


    List<UserEntity> findByEmail(String mailId);



    List<UserEntity> findByEmailAndPassword(String email,String password);


}
