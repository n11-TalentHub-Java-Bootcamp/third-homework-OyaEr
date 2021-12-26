package com.oyaerdayi.springboot.service.entityService;

import com.oyaerdayi.springboot.entity.User;
import com.oyaerdayi.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserEntityService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){

        return userRepository.findAll();
    }

    public User findById(String id){

        Optional<User> optional = userRepository.findById(id);

        User user = null;
        if (optional.isPresent()){
            user = optional.get();
        }

        return user;
    }

    public void deleteById(String id){
        userRepository.deleteById(id);
    }

    public User save(User user){
        return userRepository.save(user);
    }


}
