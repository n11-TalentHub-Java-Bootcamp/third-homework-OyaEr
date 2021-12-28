package com.oyaerdayi.springboot.controller;

import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.oyaerdayi.springboot.converter.UserConverter;
import com.oyaerdayi.springboot.dto.UserDto;
import com.oyaerdayi.springboot.entity.User;
import com.oyaerdayi.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Bu class Kullanıcı işlemlerini gerçekleştirmek için yazılmıştır.

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/userList")
    public MappingJacksonValue findAll() {
        List<User> userList;

        userList = userService.findAll();

        List<UserDto> userDtoList = UserConverter.INSTANCE.convertUserListToUserDtoList(userList);


        SimpleBeanPropertyFilter filter= SimpleBeanPropertyFilter.filterOutAllExcept("name","surname","userName");

        SimpleFilterProvider filters = new SimpleFilterProvider().addFilter("UserDtoFilter",filter);

        MappingJacksonValue mapping = new MappingJacksonValue(userDtoList);

        mapping.setFilters(filters);



        return mapping;

    }

    @GetMapping("/user/{id}")
    public MappingJacksonValue findById(@PathVariable String id) {
        User user = userService.findById(id);
        UserDto userDto = UserConverter.INSTANCE.convertUserToUserDto(user);

        SimpleBeanPropertyFilter filter= SimpleBeanPropertyFilter.filterOutAllExcept("name","surname","userName");

        SimpleFilterProvider filters = new SimpleFilterProvider().addFilter("UserDtoFilter",filter);

        MappingJacksonValue mapping = new MappingJacksonValue(userDto);

        mapping.setFilters(filters);
        return mapping;
    }

    @PostMapping("")
    public ResponseEntity<Object> save(@RequestBody UserDto userDto) {

        User user = UserConverter.INSTANCE.convertUserDtoToUser(userDto);

        user = userService.save(user);

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        userService.delete(id);
    }

}
