package com.oyaerdayi.springboot.service.entityService;

import com.oyaerdayi.springboot.entity.ProductComment;
import com.oyaerdayi.springboot.repository.ProductCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductCommentEntityService {

    @Autowired
    private ProductCommentRepository productCommentRepository;

    public List<ProductComment> findAll(){

        return productCommentRepository.findAll();
    }

    public ProductComment findById(String id){

        Optional<ProductComment> optional = productCommentRepository.findById(id);

        ProductComment productComment = null;
        if (optional.isPresent()){
            productComment = optional.get();
        }

        return productComment;
    }

    public void deleteById(String id){
        productCommentRepository.deleteById(id);
    }

    public ProductComment save(ProductComment productComment){
        return productCommentRepository.save(productComment);
    }
}
