package me.pig.minyul.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class StockController {

    private final StockGateway stockGateway;

    @GetMapping("/test")
    public void stockTest() {
        int bite = 0xff;
        byte[] bytes = {
                73, 73, 73, 73, 73, 73, 73, 73, 73, 73, 73, 73, 73, 73, 73, 73,
                (byte) bite};
        stockGateway.send(bytes);
    }
}
