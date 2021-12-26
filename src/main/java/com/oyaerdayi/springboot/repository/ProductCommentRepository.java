package com.oyaerdayi.springboot.repository;

import com.oyaerdayi.springboot.entity.Product;
import com.oyaerdayi.springboot.entity.ProductComment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductCommentRepository extends MongoRepository<ProductComment,String> {

    List<ProductComment> findById();
}
