package dev.al.internship.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


    @RestController
    public class HelloController {


        @GetMapping("/hello")
        public String hello() {

            return "Hi Internship";

        }
    }

