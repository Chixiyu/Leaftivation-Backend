package com.huilidevelopers.leaftivation.mapper;

import com.huilidevelopers.leaftivation.entity.Award;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AwardMapper {
    @Select("select * from award order by upload_time desc limit #{first}, #{first+last}")
    public List<Award> getAwardsByTimeDesc(int first, int last);

    @Select("select * from award order by upload_time asc limit #{first}, #{first+last}")
    public List<Award> getAwardsByTimeAsc(int first, int last);

    @Select("select * from award order by price desc limit #{first}, #{first+last}")
    public List<Award> getAwardByPriceDesc(int first, int last);

    @Select("select * from award order by price asc limit #{first}, #{first+last}")
    public List<Award> getAwardByPriceAsc(int first, int last);

    @Select("select * from award order by name desc limit #{first}, #{first+last}")
    public List<Award> getAwardByNameDesc(int first, int last);

    @Select("select * from award order by name asc limit #{first}, #{first+last}")
    public List<Award> getAwardByNameAsc(int first, int last);

    @Select("select * from award where id=#{id}")
    public Award getAwardById(int id);

}
