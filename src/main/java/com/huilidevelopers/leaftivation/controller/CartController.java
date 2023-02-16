package com.huilidevelopers.leaftivation.controller;

import com.huilidevelopers.leaftivation.entity.CartAward;
import com.huilidevelopers.leaftivation.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class CartController {
    @Resource
    CartService cartService;

    @GetMapping("/cart/add")
    public boolean addToCart(Long userId,Long awardId,int count){
        return cartService.addToCart(userId,awardId,count);
    }

    @GetMapping("/cart/getCart")
    public List<CartAward> getCart(Long userId){
        return cartService.getCart(userId);
    }

    @GetMapping("/cart/totalPrice")
    public Double getCartTotalPrice(Long userId){
        return cartService.getCartTotalPrice(userId);
    }

    @GetMapping("/cart/purchase")
    public String purchaseCart(Long userId){
        return cartService.purchaseCart(userId);
    }
}
