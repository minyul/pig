package me.minyul.controller;


import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import me.minyul.common.ApiTest;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloControllerRestAssuredTest extends ApiTest {

    @Test
    void helloTest() {
        ExtractableResponse<Response> response = HelloSteps.Hello_조회요청();

        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.asString()).isEqualTo("hello");
    }
}
