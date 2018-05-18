package com.example.momgoExample.MongoSpringBoot.repository;


import com.example.momgoExample.MongoSpringBoot.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends MongoRepository<User, String> {
}
