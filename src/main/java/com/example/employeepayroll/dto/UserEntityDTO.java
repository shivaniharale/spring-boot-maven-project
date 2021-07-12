package com.example.employeepayroll.dto;

import com.example.employeepayroll.entity.Employee;

import javax.persistence.Column;

public class UserEntityDTO {

    private String userNameEntity;
    private String passwordEntity;
    private String role;
    private String userEmail;
    private Employee employee;


    public UserEntityDTO() {

    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
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

    public String getRole() {
        return role;
    }


    public void setRole(String role) {
        this.role = role;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
