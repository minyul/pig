package me.minyul.controller;

import lombok.RequiredArgsConstructor;
import me.minyul.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
public class HelloController {

    private final HelloService helloService;

    @GetMapping("/hello")
    public String hello() {
        return helloService.hello();
    }

    @GetMapping("/hello/object")
    public HelloResponse helloObject() {
        return helloService.getHelloResponse();
    }
}
