package com.huilidevelopers.leaftivation.mapper;

import com.huilidevelopers.leaftivation.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository

public interface HomePageMapper {
    @Select("select intro from introduction")
    public String selectIntroduction();
}
