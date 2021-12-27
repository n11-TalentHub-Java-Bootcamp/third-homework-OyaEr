package com.oyaerdayi.springboot.controller;

import com.oyaerdayi.springboot.converter.UserConverter;
import com.oyaerdayi.springboot.dto.UserDto;
import com.oyaerdayi.springboot.entity.User;
import com.oyaerdayi.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/userList")
    public List<UserDto> findAll() {
        List<User> userList;

        userList = userService.findAll();

        List<UserDto> userDtoList = new ArrayList<UserDto>();


        for (User user : userList) {
            UserDto userDto = UserConverter.INSTANCE.convertUserToUserDto(user);
            userDtoList.add(userDto);
        }

        return userDtoList;
    }

    @GetMapping("/user/{id}")
    public UserDto findById(@PathVariable String id) {
        User user = userService.findById(id);
        UserDto userDto = UserConverter.INSTANCE.convertUserToUserDto(user);
        return userDto;
    }

    @PostMapping("")
    public ResponseEntity<Object> save(@RequestBody User user) {

        user = userService.save(user);

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        userService.delete(id);
    }

}
