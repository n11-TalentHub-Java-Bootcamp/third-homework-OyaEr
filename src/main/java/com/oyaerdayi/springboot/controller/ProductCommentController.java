package com.oyaerdayi.springboot.controller;

import com.oyaerdayi.springboot.converter.ProductCommentConverter;
import com.oyaerdayi.springboot.converter.UserConverter;
import com.oyaerdayi.springboot.dto.ProductCommentDto;
import com.oyaerdayi.springboot.dto.UserDto;
import com.oyaerdayi.springboot.entity.ProductComment;
import com.oyaerdayi.springboot.entity.User;
import com.oyaerdayi.springboot.service.ProductCommentService;
import com.oyaerdayi.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class ProductCommentController {

    @Autowired
    private ProductCommentService productCommentService;

    @GetMapping("/commentList")
    public List<ProductCommentDto> findAll() {

        List<ProductComment> commentList;

        commentList = productCommentService.findAll();

        List<ProductCommentDto> commentDtoList = new ArrayList<ProductCommentDto>();


        for (ProductComment comment : commentList) {
            ProductCommentDto commentDto = ProductCommentConverter.INSTANCE.convertProductCommentToProductCommentDto(comment);
            commentDtoList.add(commentDto);
        }

        return commentDtoList;


    }

    @GetMapping("/comment/{id}")
    public ProductCommentDto findById(@PathVariable String id) {
        ProductComment comment = productCommentService.findById(id);
        ProductCommentDto commentDto = ProductCommentConverter.INSTANCE.convertProductCommentToProductCommentDto(comment);
        return commentDto;


    }

    @PostMapping("")
    public ResponseEntity<Object> save(@RequestBody ProductComment productComment) {

        productComment = productCommentService.save(productComment);

        return new ResponseEntity<>(productComment, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        productCommentService.delete(id);
    }
}
