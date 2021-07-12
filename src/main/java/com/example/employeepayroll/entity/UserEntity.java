package com.example.employeepayroll.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import org.hibernate.envers.Audited;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;


@Entity
@Table(name = "users")
@Audited
public class UserEntity extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @Column(name = "username")
    private String userNameEntity;

    @NotNull
    @Column(name = "password")
    private String passwordEntity;

    @NotNull
    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "role")
    private String role;

    @Column(name = "enabled")
    private Boolean enabled;

    @Column(name = "one_time_password")
    private String oneTimePassword;

    @Column(name = "otp_requested_time")
    private Date otpRequestedTime;

//    @OneToOne( cascade=CascadeType.ALL)
//    @JoinColumn(name="user_employee")
//    @JsonIgnore
//    private Employee employee;

    public UserEntity() {
    }

    public UserEntity(String userNameEntity, String passwordEntity) {
        this.userNameEntity = userNameEntity;
        this.passwordEntity = passwordEntity;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getOneTimePassword() {
        return oneTimePassword;
    }

    public void setOneTimePassword(String oneTimePassword) {
        this.oneTimePassword = oneTimePassword;
    }

    public Date getOtpRequestedTime() {
        return otpRequestedTime;
    }

    public void setOtpRequestedTime(Date otpRequestedTime) {
        this.otpRequestedTime = otpRequestedTime;
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

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

//    public Employee getEmployee() {
//        return employee;
//    }
//
//    public void setEmployee(Employee employee) {
//        this.employee = employee;
//    }


    @PrePersist
    public void setAuditPrePersist(){
        this.setCreatedDate(Instant.now());
        this.setCreatedBy(SecurityContextHolder.getContext().getAuthentication().getName());
    }

    @PreUpdate
    public void setAuditPreUpdate(){
        this.setLastUpdatedDate(Instant.now());
        this.setLastUpdatedBy(SecurityContextHolder.getContext().getAuthentication().getName());
    }


}
