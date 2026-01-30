package database;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseConnectionTest {

    private DatabaseConnection dbConnection;

    @BeforeEach
    void setUp() {
        dbConnection = new DatabaseConnection();
        dbConnection.connect(); // runs before each test
    }

    @AfterEach
    void tearDown() {
        dbConnection.disconnect(); // runs after each test
    }

    @Test
    void testConnectionIsEstablished() {
        assertTrue(dbConnection.isConnected(), "Connection should be established");
    }

    @Test
    void testConnectionIsClosedAfterDisconnect() {
        dbConnection.disconnect();
        assertFalse(dbConnection.isConnected(), "Connection should be closed");
    }
}
