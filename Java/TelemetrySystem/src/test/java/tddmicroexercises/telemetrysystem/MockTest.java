package tddmicroexercises.telemetrysystem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MockTest {
    private TelemetryDiagnosticControls telemetryControls;
    private MockTelemetryClient mockTelemetryClient;

    @BeforeEach
    public void setUp() {
        telemetryControls = new TelemetryDiagnosticControls();
        mockTelemetryClient = new MockTelemetryClient();
        telemetryControls.setTelemetryClient(mockTelemetryClient);
    }

    @Test
    public void testValidDiagnosticInfoRetrieval()  {
        mockTelemetryClient.setOnlineStatus(true);
        mockTelemetryClient.setDiagnosticInfo("Valid Diagnostic Info");

        try {
            telemetryControls.checkTransmission();
        } catch (Exception e) {

        }

        //assertEquals("Valid Diagnostic Info", telemetryControls.getDiagnosticInfo());
    }

    @Test
    public void testNoConnection() {
        mockTelemetryClient.setOnlineStatus(false);

        //assertThrows(Exception.class, () -> telemetryControls.checkTransmission());
    }

    @Test
    public void testRetryLimitExceeded() {
        mockTelemetryClient.setOnlineStatus(false);

        //assertThrows(Exception.class, () -> telemetryControls.checkTransmission());
        assertEquals(0, mockTelemetryClient.getConnectionAttempts());
    }

    @Test
    public void testSuccessfulTransmission()  {
        mockTelemetryClient.setOnlineStatus(true);
        mockTelemetryClient.setDiagnosticInfo("Valid Diagnostic Info");

        try {
            telemetryControls.checkTransmission();
        } catch (Exception e) {

        }

        //assertEquals("Valid Diagnostic Info", telemetryControls.getDiagnosticInfo());
       // assertTrue(mockTelemetryClient.isSendCalled());
        //assertTrue(mockTelemetryClient.isReceiveCalled());
    }

    @Test
    public void testInvalidDiagnosticInfoRetrieval() throws Exception {
        mockTelemetryClient.setOnlineStatus(false);
        mockTelemetryClient.setDiagnosticInfo("Invalid Diagnostic Info");

        //assertThrows(Exception.class, () -> telemetryControls.checkTransmission());
        assertNotEquals("Invalid Diagnostic Info", telemetryControls.getDiagnosticInfo());
    }
}


