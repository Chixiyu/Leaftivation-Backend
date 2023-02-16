package com.huilidevelopers.leaftivation.service;

import com.huilidevelopers.leaftivation.entity.CartAward;
import com.huilidevelopers.leaftivation.mapper.CartMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class CartService {
    @Resource
    CartMapper cartMapper;

    @Resource
    PointsService pointsService;

    public boolean addToCart(Long userId,Long awardId,int count){
        try{
            cartMapper.addToCart(userId,awardId,count);
            return true;
        }
        catch (Exception e){
            log.error(e.getMessage());
            return false;
        }
    }


    public List<CartAward> getCart(Long userId){
        return cartMapper.getCart(userId);
    }

    public Double getCartTotalPrice(Long userId){
        List<CartAward> awardsInCart=cartMapper.getCartTotalPrice(userId);
        double totalPrice=0;
        for(CartAward i:awardsInCart){
            totalPrice+=i.getCount()*i.getPrice();
        }
        return totalPrice;
    }

    public String purchaseCart(Long userId){
        try{
            double currentPoint= pointsService.getCurrentPoint(userId);
            double cartTotalPrice=getCartTotalPrice(userId);
            if(currentPoint>=cartTotalPrice){// user has enough point to purchase
                pointsService.reducePoint(userId,cartTotalPrice);// reduce user's current point
                cartMapper.uploadTransaction(userId);// basically copy the cart to the admin channel
                cartMapper.clearCart(userId);// clear the cart
                return "Successful";
            }
            else{
                return "You don't have enough points, you still need "+(cartTotalPrice-currentPoint)+" points";
            }
        }
        catch (Exception e){
            e.printStackTrace();
            return "Exception happens";
        }
    }
}
