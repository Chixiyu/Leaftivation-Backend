package com.huilidevelopers.leaftivation.service;

import com.huilidevelopers.leaftivation.entity.Award;
import com.huilidevelopers.leaftivation.mapper.AwardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AwardService {

    @Resource
    AwardMapper awardMapper;

    public List<Award> getAwards(int choice, int first, int last){
        switch (choice){
            case 1-> {
                return awardMapper.getAwardsByTimeDesc(first,last);
            }
            case 2->{
                return awardMapper.getAwardsByTimeAsc(first,last);
            }
            case 3->{
                return awardMapper.getAwardByPriceDesc(first,last);
            }
            case 4->{
                return awardMapper.getAwardByPriceAsc(first,last);
            }
            case 5->{
                return awardMapper.getAwardByNameDesc(first,last);
            }
            case 6->{
                return awardMapper.getAwardByNameAsc(first,last);
            }
            default -> throw new RuntimeException("Wrong choice code, it must between 1-6");
        }
    }
    public Award selectAward(int id){
        return awardMapper.getAwardById(id);
    }
}
