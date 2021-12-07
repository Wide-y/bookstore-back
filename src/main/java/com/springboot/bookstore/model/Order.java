package com.springboot.bookstore.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.springboot.bookstore.entity.Cart;
import com.springboot.bookstore.entity.OrderItem;
import com.springboot.bookstore.entity.OrderList;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Order {
    private Integer userId;
    private String name;
    private String address;
    private String tel;
    private Integer itemNum;
    private Double totPrice;
    private List<Cart> cartList;
    private String indexBook;

    public OrderList getOrderList() {
        OrderList orderList = new OrderList();
        orderList.setUserId(this.userId);
        orderList.setName(this.name);
        orderList.setAddress(this.address);
        orderList.setTel(this.tel);
        orderList.setItemNum(this.cartList.size());
        orderList.setTotPrice(this.totPrice);
        orderList.setIndexBook(this.indexBook);
        return orderList;
    }
    public List<OrderItem> generateOrderItems(Integer listId){
        List<OrderItem> orderItems = new ArrayList<>();
        for (Cart cart:this.cartList){
            OrderItem orderItem = new OrderItem();
            orderItem.setListId(listId);
            orderItem.setBookId(cart.getBookId());
            orderItem.setNum(cart.getNum());
            orderItems.add(orderItem);
        }
        return orderItems;
    }
}
