package com.huilidevelopers.leaftivation.mapper;

import com.huilidevelopers.leaftivation.entity.Log;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UploadMapper {
    @Insert("insert into log(user_id, transportation_type, amount) values(#{userId},#{transportationType},#{amount})")
    public void uploadLog(Long userId, int transportationType, Long amount);

    @Select("select id from log where user_id=#{userId} and transportation_type=#{transportationType} and amount=#{amount} order by log_time desc limit 1")
    public Long getLogId(Long userId, int transportationType, Long amount);

    @Insert("insert into log_picture(log_id, picture_position) values(#{logId},#{picturePosition})")
    public void uploadPicture(Long logId, String picturePosition);

    @Select("select * from log join log_picture on log.id=log_picture.log_id where user_id=#{userId}")
    public List<Log> getLogs(Long userId);

    @Delete("delete from log where user_id=#{userId} and id=#{logId}")
    public void deleteLog(Long userId,Long logId);

    @Delete("delete from log_picture where log_id=#{logId} and picture_id=#{pictureId}")
    public void deletePicture(Long logId,Long pictureId);

    @Select("select picture_position from log_picture where picture_id=#{pictureId}")
    public String getPicturePositionById(Long pictureId);
}