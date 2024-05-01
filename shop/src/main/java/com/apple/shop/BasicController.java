package com.apple.shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BasicController {
    @GetMapping("/")
    @ResponseBody
    String hello(){
        return "안녕하세요";
    }

    @GetMapping("/URL")
    @ResponseBody
    String hellos(){
        return "안농";
    }
}
