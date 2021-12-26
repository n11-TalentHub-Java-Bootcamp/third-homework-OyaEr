package com.oyaerdayi.springboot.service;

import com.oyaerdayi.springboot.entity.ProductComment;

import java.util.List;

public interface ProductCommentService {

    List<ProductComment> findAll();

    ProductComment findById(String id) ;

    ProductComment save(ProductComment category);

    void delete(String id) ;


}
