package com.oyaerdayi.springboot.repository;

import com.oyaerdayi.springboot.entity.ProductComment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductCommentRepository extends MongoRepository<ProductComment,String> {
}
