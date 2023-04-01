package me.minyul.repository;

import me.minyul.entity.Invoice;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class IssuedInvoices {
    public List<Invoice> findAll() {
        return Collections.emptyList();
    }
}
