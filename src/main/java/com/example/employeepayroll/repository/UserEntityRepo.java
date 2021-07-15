package com.example.employeepayroll.repository;

import com.example.employeepayroll.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEntityRepo extends JpaRepository<UserEntity,Integer> {

    UserEntity findByUserNameEntity(String userName);

    UserEntity findByOneTimePassword(String OTP);

}
