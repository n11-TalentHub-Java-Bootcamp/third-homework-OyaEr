package com.oyaerdayi.springboot.service;

import com.oyaerdayi.springboot.entity.User;
import com.oyaerdayi.springboot.service.entityService.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserEntityService userEntityService;

    public List<User> findAll() {
        return userEntityService.findAll();
    }

    public User findById(String id) {
        return userEntityService.findById(id);
    }

    public User save(User user) {
        return userEntityService.save(user);
    }

    public void delete(String id) {
        userEntityService.deleteById(id);
    }
}
