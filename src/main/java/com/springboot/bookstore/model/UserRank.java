package com.springboot.bookstore.model;

import lombok.Data;

@Data
public class UserRank {
    private User user;
    private Double price;

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof UserRank) {
            return this.user.getUserId().equals(((UserRank) obj).user.getUserId());
        } else return false;
    }

    public UserRank(User user,Double price){
        this.user = user;
        this.price=price;
    }
}
