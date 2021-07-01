package com.example.employeepayroll.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.envers.Audited;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "users")
@Audited
public class UserEntity extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "username")
    private String userNameEntity;

    @Column(name = "password")
    private String passwordEntity;

    @Column(name = "role")
    private String role;

    @Column(name = "enabled")
    private Boolean enabled;

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
