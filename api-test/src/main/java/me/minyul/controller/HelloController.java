package me.minyul.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/object")
    public HelloResponse helloObject() {
        return new HelloResponse(2, new HelloResponse.InnerValue("string_1", 1L));
    }
}
