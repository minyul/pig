package me.minyul.repository;

import me.minyul.entity.Invoice;

public interface SAP {
    void send(Invoice invoice);
}
