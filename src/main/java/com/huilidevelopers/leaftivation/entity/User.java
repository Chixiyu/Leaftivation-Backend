package com.huilidevelopers.leaftivation.entity;

public class User {
    private Long id;
    private String username;
    private Double currentPoint;
    private Double accumulatedPoint;
    private String avatarPos;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Double getCurrentPoint() {
        return currentPoint;
    }

    public void setCurrentPoint(Double currentPoint) {
        this.currentPoint = currentPoint;
    }

    public Double getAccumulatedPoint() {
        return accumulatedPoint;
    }

    public void setAccumulatedPoint(Double accumulatedPoint) {
        this.accumulatedPoint = accumulatedPoint;
    }

    public String getAvatarPos() {
        return avatarPos;
    }

    public void setAvatarPos(String avatarPos) {
        this.avatarPos = avatarPos;
    }
}
