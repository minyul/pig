package me.pig.minyul.adapter.in.web;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway(name = "stockMessagingGateway", defaultRequestChannel = "stockRequestInputChannel_Client.input")
public interface StockGateway {

    @Gateway
    void send(byte[] payload);
}
