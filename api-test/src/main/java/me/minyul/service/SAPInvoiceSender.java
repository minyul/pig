package me.minyul.service;

import me.minyul.entity.Invoice;
import me.minyul.repository.SAP;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SAPInvoiceSender {

    private final InvoiceFilter invoiceFilter;
    private final SAP sap;

    public SAPInvoiceSender(
            InvoiceFilter invoiceFilter,
            SAP sap) {
        this.invoiceFilter = invoiceFilter;
        this.sap = sap;
    }

    public void sendLowValuedInvoices() {
        List<Invoice> lowValuedInvoices = invoiceFilter.lowValueInvoices();
        for (Invoice invoice : lowValuedInvoices) {
            sap.send(invoice);
        }
    }
}
