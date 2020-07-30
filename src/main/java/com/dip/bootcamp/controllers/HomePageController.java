package com.dip.bootcamp.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = ("/home-page"))
public class HomePageController {

    @GetMapping(value = {"", "/"})
    public ResponseEntity<?> homePage() {
        return ResponseEntity.ok("This is Your Home Page");
    }

}
