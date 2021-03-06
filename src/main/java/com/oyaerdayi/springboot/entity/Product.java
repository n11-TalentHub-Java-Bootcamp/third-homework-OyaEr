package com.oyaerdayi.springboot.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.math.BigDecimal;

@Document(collection="product")
public class Product implements Serializable {

    @Id
    private String id;
    private String name;
    private BigDecimal price;
    private String createDate;
    private String categoryId;

    public Product(String id, String name, BigDecimal price, String createDate, String categoryId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.createDate = createDate;
        this.categoryId = categoryId;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }
}
