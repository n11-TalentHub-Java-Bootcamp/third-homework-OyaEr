package com.oyaerdayi.springboot.repository;

import com.oyaerdayi.springboot.dto.UserDto;
import com.oyaerdayi.springboot.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User,String> {


}
