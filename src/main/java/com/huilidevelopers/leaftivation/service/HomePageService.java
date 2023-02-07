package com.huilidevelopers.leaftivation.service;


import com.huilidevelopers.leaftivation.mapper.HomePageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class HomePageService {
    @Resource
    HomePageMapper homePageMapper;

    public String getIntroduction(){
        return homePageMapper.selectIntroduction();
    }

}
