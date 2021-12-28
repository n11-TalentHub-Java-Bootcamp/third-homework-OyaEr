package com.oyaerdayi.springboot.converter;

import com.oyaerdayi.springboot.dto.UserDto;
import com.oyaerdayi.springboot.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;


//Bu class User ve UserDto arasındaki "mapping" işlemleri için yazılmıştır.

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserConverter {

    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);

    UserDto convertUserToUserDto(User user);

    User convertUserDtoToUser(UserDto userDto);

    List<UserDto> convertUserListToUserDtoList(List<User> userList);


}
