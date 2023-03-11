package com.huilidevelopers.leaftivation.service;

import com.huilidevelopers.leaftivation.entity.Log;
import com.huilidevelopers.leaftivation.mapper.UploadMapper;
import com.huilidevelopers.leaftivation.util.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;

@Slf4j
@Service
public class UploadService {
    @Resource
    UploadMapper uploadMapper;

    public Long uploadLog(Long userId, int transportationType, Long amount) {
        try {
            uploadMapper.uploadLog(userId, transportationType, amount);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return uploadMapper.getLogId(userId,transportationType,amount);
    }

    @Value("${picture.path}")
    private String filePath;
    public String savePicture(MultipartFile file,String userName) throws Exception {
        filePath+=userName;
        String fileName=file.getOriginalFilename();
        FileUtil.uploadFile(file.getBytes(),filePath,fileName);
        return filePath+fileName;
    }

    public void uploadPicture(Long logId, String picturePosition) {
        uploadMapper.uploadPicture(logId, picturePosition);
    }

    public List<Log> getLogs(Long userId){
        return uploadMapper.getLogs(userId);
    }

    public boolean deleteLog(Long userId,Long logId){
        try{
            uploadMapper.deleteLog(userId,logId);
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public boolean deletePictureFile(String picturePosition){
        File file=new File(picturePosition);
        return file.delete();
    }

    public void deletePicture(Long logId,Long pictureId){
        try{
            uploadMapper.deletePicture(logId,pictureId);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
