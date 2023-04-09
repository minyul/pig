package me.minyul.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(HelloController.class)
class HelloControllerTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnHelloString() throws Exception {
        String contentAsString = mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        String result = objectMapper.convertValue(contentAsString, String.class);
        assertThat(result).isEqualTo("hello");
    }

    @Test
    void shouldReturnHelloResponse() throws Exception {
        String response = mockMvc.perform(get("/hello/object"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        HelloResponse result = objectMapper.readValue(response, HelloResponse.class);

        assertThat(result.getKey()).isEqualTo(2);
    }
}