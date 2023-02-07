package com.huilidevelopers.leaftivation.controller;


import com.huilidevelopers.leaftivation.entity.Award;
import com.huilidevelopers.leaftivation.service.AwardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class AwardController {
    @Resource
    AwardService awardService;

    @GetMapping("/award/get")
    public List<Award> getAwards(int choice, int first, int last){
        return awardService.getAwards(choice,first,last);
    }

    @GetMapping("/award/select")
    public Award selectAward(int id){
        return awardService.selectAward(id);
    }


}
