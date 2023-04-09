package me.minyul.service;

import me.minyul.controller.HelloResponse;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String hello() {
        return "hello";
    }

    public HelloResponse getHelloResponse() {
        return new HelloResponse(2, new HelloResponse.InnerValue("string_1", 1L));
    }
}
