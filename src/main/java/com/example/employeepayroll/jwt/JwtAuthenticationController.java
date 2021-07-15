package com.example.employeepayroll.jwt;

import com.example.employeepayroll.dto.UserEntityDTO;
import com.example.employeepayroll.entity.UserEntity;
import com.example.employeepayroll.repository.UserEntityRepo;
import com.example.employeepayroll.service.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.bind.ValidationException;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;

    @Autowired
    private UserEntityRepo userEntityRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private OtpService otpService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest,
                                                       HttpServletRequest httpServletRequest) throws Exception {
        authenticate(authenticationRequest.getUserName(),authenticationRequest.getPassword());
        final UserDetails userDetails=jwtUserDetailsService
                                              .loadUserByUsername(authenticationRequest.getUserName());
        final String token=jwtTokenUtil.generateToken(userDetails,httpServletRequest);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    @RequestMapping(value = "/signup",method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody UserEntityDTO userEntityDTO)throws Exception{

        try {
            jwtUserDetailsService.saveUser(userEntityDTO);
            UserEntity user=userEntityRepo.findByUserNameEntity(userEntityDTO.getUserNameEntity());
            otpService.generateOTP(userEntityDTO.getUserNameEntity());
            otpService.sendOTP(user.getUserEmail(),user.getOneTimePassword());
        } catch (MessagingException e) {
            e.printStackTrace();
        }
//        otpService.clearOTP(user);
        return ResponseEntity.ok("Sign Up Successful");
    }

    @PostMapping("email-verification")
    public ResponseEntity<?> emailVerification(@RequestParam("OTP") String OTP,
                                               @RequestParam("userName") String userName) throws ValidationException {

        try {
            if(OTP==userEntityRepo.findByUserNameEntity(userName).getOneTimePassword()){
                UserEntity userEntity=userEntityRepo.findByUserNameEntity(userName);
                userEntity.setVerified(true);
                otpService.clearOTP(userName);

            }
            else {
                throw new ValidationException("Invalid OTP");
            }
        } catch (ValidationException e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok("Email Verification Successful");

    }

    @PostMapping("/updatepassword")
    public ResponseEntity<?> changePassword(@RequestParam("oldPassword") String oldPassword,
                                            @RequestParam("newPassword") String newPassword) throws Exception {
        authenticate(SecurityContextHolder.getContext().getAuthentication().getName(),oldPassword);
        UserEntity userEntity= userEntityRepo.findByUserNameEntity(SecurityContextHolder.getContext().getAuthentication().getName());

        userEntity.setPasswordEntity(passwordEncoder.encode(newPassword));

        userEntityRepo.save(userEntity);

        return ResponseEntity.ok("Password updated successfully");
    }

//    @GetMapping("/logout")
//    public ResponseEntity<?> logout(HttpServletRequest request){
//        HttpSession session=request.getSession();
//        String requestTokenHeader=request.getHeader("Authorization");
//        if (requestTokenHeader != null && requestTokenHeader.contains("Bearer")) {
//            session.invalidate();
//        }
//        return ResponseEntity.ok("Logout successful");
//    }



    private void authenticate(String userName,String password) throws Exception{
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName,password));
        }catch (DisabledException e){
            throw new Exception("User Disabled",e);
        }catch (BadCredentialsException e){
            throw new Exception("Invalid Credentials",e);
        }
    }

}
