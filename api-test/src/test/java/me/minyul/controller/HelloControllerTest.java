package me.minyul.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.minyul.service.HelloService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(HelloController.class)
class HelloControllerTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HelloService helloService;

    @Test
    void shouldReturnHelloString() throws Exception {
        // given
        when(helloService.hello()).thenReturn("hello");

        String contentAsString = mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        String result = objectMapper.convertValue(contentAsString, String.class);
        assertThat(result).isEqualTo("hello");
    }

    @Test
    void shouldReturnHelloResponse() throws Exception {
        // given
        when(helloService.getHelloResponse())
                .thenReturn(new HelloResponse(2, new HelloResponse.InnerValue("string_1", 1L)));

        String response = mockMvc.perform(get("/hello/object"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        HelloResponse result = objectMapper.readValue(response, HelloResponse.class);

        assertThat(result.getKey()).isEqualTo(2);
    }
}