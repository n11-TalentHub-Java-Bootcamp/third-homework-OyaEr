package com.oyaerdayi.springboot.controller;

import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.oyaerdayi.springboot.converter.ProductCommentConverter;
import com.oyaerdayi.springboot.dto.ProductCommentDto;
import com.oyaerdayi.springboot.entity.ProductComment;
import com.oyaerdayi.springboot.service.ProductCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import java.util.List;


//Bu class ÜrünYorum işlemlerini gerçekleştirmek için yazılmıştır.

@RestController
@RequestMapping("/api/comments")
public class ProductCommentController {

    @Autowired
    private ProductCommentService productCommentService;

    @GetMapping("/commentList")
    public MappingJacksonValue findAll() {

        List<ProductComment> commentList;

        commentList = productCommentService.findAll();

        List<ProductCommentDto> commentDtoList = ProductCommentConverter.INSTANCE.convertProductCommentListToProductCommentDtoList(commentList);


        SimpleBeanPropertyFilter filter= SimpleBeanPropertyFilter.filterOutAllExcept("comment","commentDate");

        SimpleFilterProvider filters = new SimpleFilterProvider().addFilter("ProductCommentDtoFilter",filter);

        MappingJacksonValue mapping = new MappingJacksonValue(commentDtoList);

        mapping.setFilters(filters);



        return mapping;


    }

    @GetMapping("/comment/{id}")
    public MappingJacksonValue findById(@PathVariable String id) {
        ProductComment comment = productCommentService.findById(id);

        ProductCommentDto commentDto = ProductCommentConverter.INSTANCE.convertProductCommentToProductCommentDto(comment);

        SimpleBeanPropertyFilter filter= SimpleBeanPropertyFilter.filterOutAllExcept("comment","commentDate");

        SimpleFilterProvider filters = new SimpleFilterProvider().addFilter("ProductCommentDtoFilter",filter);

        MappingJacksonValue mapping = new MappingJacksonValue(commentDto);

        mapping.setFilters(filters);
        return mapping;


    }

    @PostMapping("")
    public ResponseEntity<Object> save(@RequestBody ProductCommentDto commentDto) {

        ProductComment comment = ProductCommentConverter.INSTANCE.convertProductCommentDtoToProductComment(commentDto);

        comment = productCommentService.save(comment);

        return new ResponseEntity<>(comment, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        productCommentService.delete(id);
    }
}
