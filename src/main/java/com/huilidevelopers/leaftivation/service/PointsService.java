package com.huilidevelopers.leaftivation.service;

import com.huilidevelopers.leaftivation.entity.User;
import com.huilidevelopers.leaftivation.mapper.PointsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PointsService {
    @Resource
    PointsMapper pointsMapper;
    public Double getCurrentPoint(Long userId){
        return pointsMapper.selectCurrentPointByUsername(userId);
    }

    public List<User> getLeaderboard(Long first, Long last){
        return pointsMapper.selectLeaderboardFromFirstToLast(first,first+last);
    }

    public void reducePoint(Long userId,double reduction){
        pointsMapper.reducePoint(userId,reduction);
    }

    public void increasePoint(Long userId,double increase){
        pointsMapper.reducePoint(userId,increase);
    }

}
