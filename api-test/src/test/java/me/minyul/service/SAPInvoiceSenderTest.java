package me.minyul.service;

import me.minyul.entity.Invoice;
import me.minyul.repository.SAP;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SAPInvoiceSenderTest {

    @InjectMocks
    private SAPInvoiceSender sapInvoiceSender;

    @Mock
    private InvoiceFilter invoiceFilter;

    @Mock
    private SAP sap;

    @Test
    void shouldSAP_send_2_WhenSendLowValuedInvoices() {
        Invoice A = new Invoice("A", 89);
        Invoice B = new Invoice("B", 99);

        List<Invoice> invoices = Arrays.asList(A, B);

        when(invoiceFilter.lowValueInvoices()).thenReturn(invoices);

        sapInvoiceSender.sendLowValuedInvoices();

        verify(sap).send(A);
        verify(sap).send(B);
    }
}