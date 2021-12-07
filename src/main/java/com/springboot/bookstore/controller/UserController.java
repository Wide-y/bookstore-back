package com.springboot.bookstore.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.springboot.bookstore.entity.*;
import com.springboot.bookstore.model.BookItem;
import com.springboot.bookstore.model.Order;
import com.springboot.bookstore.model.User;
import com.springboot.bookstore.model.UserRank;
import com.springboot.bookstore.service.CartService;
import com.springboot.bookstore.service.OrderService;
import com.springboot.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private CartService cartService;
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public User getUser(@RequestParam("id") Integer id) {
        return userService.findById(id);
    }

    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.GET)
    public Integer updateUserType(@RequestParam("userId") Integer id, @RequestParam("type") Integer type) {
        return userService.updateUserType(id, type);
    }

    @RequestMapping(value = "/checkLog", method = RequestMethod.GET)
    public Integer checkLog(@RequestParam("username") String username, @RequestParam("password") String password) {
        return userService.checkLog(username, password);
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public Integer addUser(@RequestParam("username") String username, @RequestParam("pwd") String pwd, @RequestParam("email") String email) {
        return userService.addAccount(username, pwd, email);
    }

    @RequestMapping(value = "/getCartlist", method = RequestMethod.GET)
    public List<BookItem> getCartlist(@RequestParam("id") Integer id) {
        return cartService.getCartlist(id);
    }

    @RequestMapping(value = "/getOrderList", method = RequestMethod.GET)
    public List<OrderList> getOrderList(@RequestParam("userId") Integer userId, @RequestParam("type") Integer type, @RequestParam("admin") Integer admin) {
        return orderService.getOrderList(userId, type, admin);
    }

    @RequestMapping(value = "/getOrderItems", method = RequestMethod.GET)
    public List<BookItem> getrOrderItems(@RequestParam("listId") Integer listId) {
        return orderService.getOrderItems(listId);
    }

    @RequestMapping(value = "/getRank", method = RequestMethod.GET)
    public List<BookItem> getRankList(@RequestParam("userId") Integer userId, @RequestParam("type") Integer type, @RequestParam("admin") Integer admin) {
        return orderService.getRanklist(userId, type, admin);
    }

    @RequestMapping(value = "/getUserRank", method = RequestMethod.GET)
    public List<UserRank> getRankList(@RequestParam("type") Integer type) {
        return orderService.getUserRank(type);
    }

    @RequestMapping(value = "/addCartItem", method = RequestMethod.GET)
    public Cart saveItem(@RequestParam("bookId") Integer bookId, @RequestParam("userId") Integer userId, @RequestParam("num") Integer num) {
        return cartService.saveItem(bookId, userId, num);
    }

    @RequestMapping(value = "/pay", method = RequestMethod.POST)
    public Integer Pay(@RequestBody Order order) {
        return orderService.saveOrder(order);
    }

    @RequestMapping(value = "/paywx", method = RequestMethod.POST)
    public Integer PayWx(@RequestParam Map<String, String> params) {
//        System.out.println(params.get("itemNum"));
//        Order order = new Order();
//        order.setUserId(Integer.parseInt(params.get("userId").toString()));
//        order.setName(params.get("name").toString());
//        order.setAddress(params.get("address").toString());
//        order.setIndexBook(params.get("indexBook").toString());
//        order.setTel(params.get("tel").toString());
//        order.setTotPrice(Double.parseDouble(params.get("totPrice").toString()));
//        order.scartlist(params.get("cartList").toString());
        JSONObject obj = JSON.parseObject(params.get("body"));
        Order order = JSONObject.toJavaObject(obj, Order.class);
        System.out.println(order);
        return orderService.saveOrder(order);
    }

    @RequestMapping(value = "/updateCart", method = RequestMethod.GET)
    public Integer updateCart(@RequestParam("id") Integer id, @RequestParam("num") Integer num) {
        return cartService.updateItem(id, num);
    }

    @RequestMapping(value = "/deleteCart", method = RequestMethod.GET)
    public Integer deleteCart(@RequestParam("id") Integer id) {
        cartService.deleteItem(id);
        return 1;
    }
}
