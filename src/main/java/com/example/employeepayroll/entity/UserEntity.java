package com.example.employeepayroll.entity;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "username")
    private String userNameEntity;

    @Column(name = "password")
    private String passwordEntity;

    //role+enabled+user_employee

    public UserEntity() {
    }

    public UserEntity(String userNameEntity, String passwordEntity) {
        this.userNameEntity = userNameEntity;
        this.passwordEntity = passwordEntity;
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
