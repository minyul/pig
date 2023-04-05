package me.minyul.repository.base;

import me.minyul.repository.InvoiceDao;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.sql.Connection;

public class SqlIntegrationTestBase {

    private Connection connection;
    protected InvoiceDao invoiceDao; // Todo : protected 써서 상속 받은 자식 객체만 접근 가능하게

    @BeforeEach
    void openConnectionAndCleanUp() {
        //
    }

    @AfterEach
    void close() {
        //
    }
}
