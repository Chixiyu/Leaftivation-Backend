package com.huilidevelopers.leaftivation.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface HomePageMapper {
    @Select("select intro from introduction")
    public String selectIntroduction();
}
