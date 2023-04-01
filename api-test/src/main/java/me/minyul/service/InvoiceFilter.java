package me.minyul.service;

import me.minyul.entity.Invoice;
import me.minyul.repository.IssuedInvoices;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvoiceFilter {

    private final IssuedInvoices issuedInvoices;

    public InvoiceFilter(IssuedInvoices issuedInvoices) {
        this.issuedInvoices = issuedInvoices;
    }

    public List<Invoice> lowValueInvoices() {
        return issuedInvoices.findAll()
                .stream().filter(invoice -> invoice.getId() < 100)
                .collect(Collectors.toList());
    }
}
