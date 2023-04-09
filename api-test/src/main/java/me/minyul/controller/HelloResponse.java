package me.minyul.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HelloResponse {

    private Integer key;
    private InnerValue value;

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class InnerValue {
        private String stringValue;
        private Long longValue;
    }
}
