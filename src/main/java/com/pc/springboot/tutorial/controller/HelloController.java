package com.pc.springboot.tutorial.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class HelloController {

    @GetMapping(value = "/")
    public String helloWorld () {
        return "Good Morning/afternoon/evening "+new Date();
    }
}
