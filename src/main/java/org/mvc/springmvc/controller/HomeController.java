package org.mvc.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String index() {
        return "/home/index";
    }
    @GetMapping("/home/privacy")
    public String hello() {
        return "/home/privacy";
    }
}
