package com.example.UrlShortener.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @RequestMapping("/hola")
    public String test() {
        return "hola";
    }
}
