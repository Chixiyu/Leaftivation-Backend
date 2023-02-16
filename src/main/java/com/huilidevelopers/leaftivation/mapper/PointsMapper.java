package com.huilidevelopers.leaftivation.mapper;

import com.huilidevelopers.leaftivation.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PointsMapper {
    @Select("select current_point from user where id=#{userId}")
    public Double selectCurrentPointByUsername(Long userId);

    @Select("select * from user order by accumulated_point limit #{first},#{end}")
    public List<User> selectLeaderboardFromFirstToLast(Long first, Long end);

    @Update("update user set current_point=current_point-#{reduction}")
    public void reducePoint(Long userId,double reduction);

    @Update("update user set current_point=current_point+#{increase}")
    public void increasePoint(Long userId,double increase);
}
