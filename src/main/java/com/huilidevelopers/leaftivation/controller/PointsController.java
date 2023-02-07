package com.huilidevelopers.leaftivation.controller;

import com.huilidevelopers.leaftivation.entity.User;
import com.huilidevelopers.leaftivation.service.PointsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class PointsController {

    @Resource
    PointsService pointsService;

    @GetMapping("/currentPoint")
    public Double getCurrentPoint(Long userId){
        return pointsService.getCurrentPoint(userId);
    }

    @GetMapping("/leaderboard")
    public List<User> getLeaderboard(Long first, Long last){
        return pointsService.getLeaderboard(first,last);
    }
}
