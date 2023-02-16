package com.huilidevelopers.leaftivation.controller;

import com.huilidevelopers.leaftivation.service.HomePageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HomePageController {
    @Resource
    private HomePageService homePageService;

    @GetMapping("/introduction")
    public String getIntroduction(){
        return homePageService.getIntroduction();
    }


    
}
