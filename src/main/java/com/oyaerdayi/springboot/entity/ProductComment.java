package com.oyaerdayi.springboot.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="productComment")
public class ProductComment {

    @Id
    private String id;
    private String comment;
    private String commentDate;
    private String productId;
    private String userId;

    public ProductComment(String id, String comment, String commentDate, String productId, String userId) {
        this.id = id;
        this.comment = comment;
        this.commentDate = commentDate;
        this.productId = productId;
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
