package com.oyaerdayi.springboot.converter;

import com.oyaerdayi.springboot.dto.UserDto;
import com.oyaerdayi.springboot.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserConverter {

    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);

    UserDto convertUserToUserDto(User user);


}
