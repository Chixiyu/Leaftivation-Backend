package com.huilidevelopers.leaftivation.mapper;

import com.huilidevelopers.leaftivation.entity.CartAward;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CartMapper {
    @Insert("insert into cart set user_id=#{userId},award_id=#{awardId},count=#{count}")
    public void addToCart(Long userId,Long awardId,int count);

    @Select("select award_id as id,name,price,description,image_position,collaborator,award.upload_time,count from cart join award on award_id where user_id=#{userId}")
    public List<CartAward> getCart(Long userId);

    @Select("select award_id as id,name,price,description,image_position,collaborator,award.upload_time,count from cart join award on award_id where user_id=#{userId}")
    public List<CartAward> getCartTotalPrice(Long userId);

    @Insert("insert into admin_transaction (award_id, award_name, award_price, description, image_position, collaborator, transaction_time, user_id)" +
            " select award_id,name as award_name, price as award_price, description,image_position,collaborator,now(),user_id" +
            " from cart join award on award_id where user_id=#{userId}")
    public void uploadTransaction(Long userId);

    @Delete("delete from cart where user_id=#{userId}")
    public void clearCart(Long userId);
}
