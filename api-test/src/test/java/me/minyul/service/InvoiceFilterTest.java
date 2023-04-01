package me.minyul.service;

import me.minyul.entity.Invoice;
import me.minyul.repository.IssuedInvoices;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class InvoiceFilterTest {

    @InjectMocks
    private InvoiceFilter invoiceFilter;

    @Mock
    private IssuedInvoices issuedInvoices;

    @Test
    void shouldReturnLessThen100InvoiceWhenLowValueInvoices() {
        Invoice A = new Invoice("A", 10);
        Invoice B = new Invoice("B", 101);

        List<Invoice> expected = List.of(A, B);
        when(issuedInvoices.findAll()).thenReturn(expected);

        List<Invoice> lowValueInvoices = invoiceFilter.lowValueInvoices();

        assertThat(lowValueInvoices).containsExactlyInAnyOrder(A);
    }

    @Test
    void shouldException_GetInvoiceWhenIdIsNull() {
        doThrow(new IllegalArgumentException("test message"))
                .when(issuedInvoices).findById(null);

        assertThatThrownBy(() -> invoiceFilter.getInvoice(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("test message");
    }
}