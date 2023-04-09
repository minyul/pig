package me.minyul.repository;

import me.minyul.entity.Invoice;
import org.springframework.stereotype.Repository;

@Repository
public class SapImpl implements SAP{
    @Override
    public void send(Invoice invoice) {

    }
}
