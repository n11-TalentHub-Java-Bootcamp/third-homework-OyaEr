package com.oyaerdayi.springboot.controller;

import com.oyaerdayi.springboot.entity.ProductComment;
import com.oyaerdayi.springboot.entity.User;
import com.oyaerdayi.springboot.service.ProductCommentService;
import com.oyaerdayi.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class ProductCommentController {

    @Autowired
    private ProductCommentService productCommentService;

    @GetMapping("/commentList")
    public List<ProductComment> findAll() {
        return productCommentService.findAll();
    }

    @GetMapping("/comment/{id}")
    public ProductComment findById(@PathVariable String id) {
        return productCommentService.findById(id);
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
