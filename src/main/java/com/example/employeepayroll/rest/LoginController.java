package com.example.employeepayroll.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @RequestMapping({"/hello"})
    public String showHome(){

        return "HELLO WORKS";


    }




}
