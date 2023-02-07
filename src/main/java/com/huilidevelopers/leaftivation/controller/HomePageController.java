package com.huilidevelopers.leaftivation.controller;

import com.huilidevelopers.leaftivation.service.HomePageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class HomePageController {
    @Resource
    HomePageService homePageService;

    @GetMapping("/introduction")
    public String getIntroduction(){
        return homePageService.getIntroduction();
    }


    
}
