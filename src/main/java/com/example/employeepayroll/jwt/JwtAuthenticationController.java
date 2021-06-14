package com.example.employeepayroll.jwt;

import com.example.employeepayroll.dto.UserEntityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;

    @RequestMapping(value = "/authenticate",method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        authenticate(authenticationRequest.getUserName(),authenticationRequest.getPassword());
        final UserDetails userDetails=jwtUserDetailsService
                                              .loadUserByUsername(authenticationRequest.getUserName());
        final String token=jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody UserEntityDTO userEntityDTO)throws Exception{

        return ResponseEntity.ok(jwtUserDetailsService.saveUser(userEntityDTO));
    }

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
