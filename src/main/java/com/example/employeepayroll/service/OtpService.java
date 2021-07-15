package com.example.employeepayroll.service;

import com.example.employeepayroll.entity.UserEntity;
import net.bytebuddy.utility.RandomString;
import org.springframework.mail.SimpleMailMessage;

import javax.mail.MessagingException;
import java.util.Date;

public interface OtpService {

    public void generateOTP(String userName) throws MessagingException;

    //sends otp using email
    public void sendOTP(String userEmail,String OTP ) throws MessagingException;

    //clear otp from userEntity table
    public void clearOTP(String userName);



}
