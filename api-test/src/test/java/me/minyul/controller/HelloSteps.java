package me.minyul.controller;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

public class HelloSteps {

    public static ExtractableResponse<Response> Hello_조회요청() {
        return RestAssured.given().log().all()
                .when()
                .get("/hello")
                .then().log().all()
                .extract();
    }
}
