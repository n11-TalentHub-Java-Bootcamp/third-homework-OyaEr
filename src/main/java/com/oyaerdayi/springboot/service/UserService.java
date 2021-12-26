package com.oyaerdayi.springboot.service;

import com.oyaerdayi.springboot.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(String id) ;

    User save(User category);

    void delete(String id) ;
}
