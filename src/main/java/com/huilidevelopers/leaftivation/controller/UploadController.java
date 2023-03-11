package com.huilidevelopers.leaftivation.controller;

import com.huilidevelopers.leaftivation.entity.Log;
import com.huilidevelopers.leaftivation.mapper.UploadMapper;
import com.huilidevelopers.leaftivation.service.UploadService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UploadController {
    @Resource
    UploadService uploadService;

    @Resource
    UploadMapper uploadMapper;

    @GetMapping("/upload/log")
    public Long uploadLog(Long userId, int transportationType, Long amount) {
        return uploadService.uploadLog(userId, transportationType, amount);
    }

    @GetMapping("/upload/picture")
    public boolean uploadPicture(Long logId, MultipartFile file, String userName) {
        try {
            //1. save the photo file to server
            String picturePosition = uploadService.savePicture(file, userName);
            //2. update the log
            uploadService.uploadPicture(logId, picturePosition);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @GetMapping("/upload/allLogs")
    public List<Log> getLogs(Long userId) {
        return uploadService.getLogs(userId);
    }

    @GetMapping("/upload/delete/log")
    public boolean deleteLog(Long userId, Long logId) {
        return uploadService.deleteLog(userId, logId);
    }

    @GetMapping("/upload/delete/picture")
    public boolean deletePicture(Long logId, Long pictureId) {
        try {
            //1. Get the picture position by picture id, so that it can be deleted
            String picturePosition = uploadMapper.getPicturePositionById(pictureId);
            //2. Delete the picture file
            boolean resp1 = uploadService.deletePictureFile(picturePosition);
            if (!resp1) return false; // there is no such file
            //3. Delete the picture recording in the database
            // note that 3 must be after 1 because 3 would delete the record in database containing picturePosition
            uploadService.deletePicture(logId, pictureId);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}