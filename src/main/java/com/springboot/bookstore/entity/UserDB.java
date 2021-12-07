package com.springboot.bookstore.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


import javax.persistence.Id;
import java.util.List;


@Data
@Document(collection = "userData")
public class UserDB {
    @Id
    @Field("_id")
    private ObjectId id;

    @Field("userId")
    private Integer userId;

    @Field("address")
    private List<String> addressList;

    @Field("tel")
    private List<String> tel;

    @Field("avatar")
    private String avatarBase64;
}
