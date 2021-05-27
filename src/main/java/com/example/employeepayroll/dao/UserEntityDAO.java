package com.example.employeepayroll.dao;

import com.example.employeepayroll.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEntityDAO extends JpaRepository<UserEntity,Integer> {

    UserEntity findByUserNameEntity(String userName);

}
