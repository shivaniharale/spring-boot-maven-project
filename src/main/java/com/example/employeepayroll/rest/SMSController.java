package com.example.employeepayroll.rest;

import com.example.employeepayroll.entity.UserEntity;
import com.example.employeepayroll.repository.UserEntityRepo;
import com.example.employeepayroll.service.OtpService;
import com.example.employeepayroll.service.SMSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class SMSController {

    @Autowired
    private SimpMessagingTemplate webSocket;

    @Autowired
    private SMSService service;

    private final String TOPIC_DESTINATION="/sms/smsOtp";

    @PostMapping("/smsOtp")
    public void smsSend(){

    service.send();
    webSocket.convertAndSend(TOPIC_DESTINATION,getTimeStamp());


    }

    private String getTimeStamp(){
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
    }


//    @Autowired
//    OtpService otpService;
//
//    @Autowired
//    UserEntityRepo userEntityRepo;
//
//    @PostMapping("/email-verification")
//    public ResponseEntity<?> getOtp(@RequestParam("username") String userName) throws MessagingException {
//
//        UserEntity user=userEntityRepo.findByUserNameEntity(userName);
//        otpService.generateOTP(userName);
//        otpService.sendOTP(user.getUserEmail(),user.getOneTimePassword());
//        otpService.clearOTP(user);
//
//        return ResponseEntity.ok("Otp Verification Successful");
//    }

}
