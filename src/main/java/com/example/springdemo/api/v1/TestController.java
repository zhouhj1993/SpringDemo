package com.example.springdemo.api.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/")
public class TestController {

    @GetMapping(value = "hello")
    public Object hello() {
        return "hello";
    }

}
