package me.minyul.service;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HelloServiceTest {

    @Autowired
    private HelloService helloService;

    @DisplayName("Say Hello")
    @Test
    void sayHello() {
        String hello = helloService.hello();
        Assertions.assertEquals(hello, "hello");
    }

    @TestConfiguration
    public static class TestConfig {

        @Bean
        public HelloService helloService() {
            return new HelloService();
        }
    }

    @Test
    void test()throws JsonProcessingException{
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            mapper.writeValueAsBytes(null);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException();
        }
    }
}