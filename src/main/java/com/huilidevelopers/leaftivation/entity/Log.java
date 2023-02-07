package com.huilidevelopers.leaftivation.entity;

import java.util.Date;

public class Log {
    private boolean audit;
    private Long userId;
    private Date logTime;
    private int transportationType;
    private Double amount;
    private Long pictureId;
    private Long LogId;
    private String picturePosition;

    public boolean isAudit() {
        return audit;
    }

    public void setAudit(boolean audit) {
        this.audit = audit;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getLogTime() {
        return logTime;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }

    public int getTransportationType() {
        return transportationType;
    }

    public void setTransportationType(int transportationType) {
        this.transportationType = transportationType;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getPictureId() {
        return pictureId;
    }

    public void setPictureId(Long pictureId) {
        this.pictureId = pictureId;
    }

    public Long getLogId() {
        return LogId;
    }

    public void setLogId(Long logId) {
        LogId = logId;
    }

    public String getPicturePosition() {
        return picturePosition;
    }

    public void setPicturePosition(String picturePosition) {
        this.picturePosition = picturePosition;
    }
}
