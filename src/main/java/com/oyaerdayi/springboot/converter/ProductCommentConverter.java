package com.oyaerdayi.springboot.converter;

import com.oyaerdayi.springboot.dto.ProductCommentDto;
import com.oyaerdayi.springboot.dto.UserDto;
import com.oyaerdayi.springboot.entity.ProductComment;
import com.oyaerdayi.springboot.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductCommentConverter {

    ProductCommentConverter INSTANCE = Mappers.getMapper(ProductCommentConverter.class);

    ProductCommentDto convertProductCommentToProductCommentDto(ProductComment comment);

}
