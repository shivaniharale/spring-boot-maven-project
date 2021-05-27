package com.example.employeepayroll.dto;

import javax.persistence.Column;

public class UserEntityDTO {

    private String userNameEntity;
    private String passwordEntity;

    public UserEntityDTO() {

    }

    public String getUserNameEntity() {
        return userNameEntity;
    }

    public void setUserNameEntity(String userNameEntity) {
        this.userNameEntity = userNameEntity;
    }

    public String getPasswordEntity() {
        return passwordEntity;
    }

    public void setPasswordEntity(String passwordEntity) {
        this.passwordEntity = passwordEntity;
    }
}
