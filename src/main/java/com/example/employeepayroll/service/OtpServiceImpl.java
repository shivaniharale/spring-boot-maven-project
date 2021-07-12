package com.example.employeepayroll.service;

import com.example.employeepayroll.entity.UserEntity;
import com.example.employeepayroll.repository.UserEntityRepo;
import liquibase.pro.packaged.A;
import liquibase.pro.packaged.O;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
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
    public void generateOTP(UserEntity userEntity) throws MessagingException {

        String OTP= RandomString.make(4);
        String encodedOTP=passwordEncoder.encode(OTP);

        userEntity.setOneTimePassword(encodedOTP);
        userEntity.setOtpRequestedTime(new Date());

        userEntityRepo.save(userEntity);

        sendOTP(userEntity, OTP);

    }

//sends otp using email
    public void sendOTP(UserEntity user,String OTP ) throws MessagingException {

        //        SimpleMailMessage email=new SimpleMailMessage();

        MimeMessage message= javaMailSender.createMimeMessage();
        MimeMessageHelper email=new MimeMessageHelper(message);

        email.setFrom("shivaniharale@gmail.com");

        email.setTo(user.getUserEmail());

        email.setSubject("Email Verification by OTP");

        email.setText("OTP is "+OTP);


        javaMailSender.send((MimeMessagePreparator) email);
    }

    //clear otp from userEntity table
    public void clearOTP(UserEntity userEntity){

        userEntity.setOneTimePassword(null);
        userEntity.setOtpRequestedTime(null);
        userEntityRepo.save(userEntity);

    }



}
