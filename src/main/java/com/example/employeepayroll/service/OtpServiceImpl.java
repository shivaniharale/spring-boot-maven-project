package com.example.employeepayroll.service;

import com.example.employeepayroll.entity.UserEntity;
import com.example.employeepayroll.repository.UserEntityRepo;

import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;
import java.util.Date;

@Service
@Transactional
public class OtpServiceImpl implements OtpService{

    @Autowired
    UserEntityRepo userEntityRepo;

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    PasswordEncoder passwordEncoder;

//generates otp and saves as encrypted otp
    public void generateOTP(String userName) throws MessagingException {

        UserEntity user=userEntityRepo.findByUserNameEntity(userName);

        String OTP= RandomString.make(4);
        String encodedOTP=passwordEncoder.encode(OTP);

        user.setOneTimePassword(encodedOTP);
        user.setOtpRequestedTime(new Date());

        userEntityRepo.save(user);

    }

//sends otp using email
    public void sendOTP(String userEmail,String OTP ) throws MessagingException {

        MimeMessage message= javaMailSender.createMimeMessage();
        MimeMessageHelper email=new MimeMessageHelper(message);

        email.setFrom("shivaniharale@gmail.com");

        email.setTo(userEmail);

        email.setSubject("Email Verification by OTP");

        email.setText("OTP is "+OTP);

        javaMailSender.send(message);
    }

    //clear otp from userEntity table
    public void clearOTP(String userName){
        UserEntity userEntity=userEntityRepo.findByUserNameEntity(userName);
        userEntity.setOneTimePassword(null);
        userEntity.setOtpRequestedTime(null);
        userEntityRepo.save(userEntity);

    }

}
