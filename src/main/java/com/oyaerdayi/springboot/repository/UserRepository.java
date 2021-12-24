package com.oyaerdayi.springboot.repository;

import com.oyaerdayi.springboot.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {
}
