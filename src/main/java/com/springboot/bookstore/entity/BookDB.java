package com.springboot.bookstore.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;

@Data
@Document(collection = "bookData")
public class BookDB {
    @Id
    @Field("_id")
    private ObjectId id;

    @Field("bookId")
    private Integer bookId;

    @Field("description")
    private String description;

    @Field("img")
    private String imgBase64;
}
