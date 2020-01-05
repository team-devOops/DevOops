package com.devoops.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test2 {


    @RequestMapping("/test2")
    public String home(){

        return  "index"; 
    }
}
