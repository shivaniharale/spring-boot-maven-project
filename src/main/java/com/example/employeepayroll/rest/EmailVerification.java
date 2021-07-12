package com.example.employeepayroll.rest;

import com.example.employeepayroll.entity.UserEntity;
import com.example.employeepayroll.repository.UserEntityRepo;
import com.example.employeepayroll.service.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.mail.MessagingException;

@Controller
public class EmailVerification {

    @Autowired
    OtpService otpService;

    @Autowired
    UserEntityRepo userEntityRepo;

    @PostMapping("/email-verification")
    public ResponseEntity<?> getOtp(@RequestParam("username") String userName) throws MessagingException {

        UserEntity user=userEntityRepo.findByUserNameEntity(userName);
        otpService.generateOTP(user);
        otpService.sendOTP(user,user.getOneTimePassword());
        otpService.clearOTP(user);

        return ResponseEntity.ok("Otp Verification Successful");
    }

}
