package tddmicroexercises.telemetrysystem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

class TelemetryDiagnosticControlsTest
{


   @Mock
    private TelemetryClient telemetryClient;

    @InjectMocks
    TelemetryDiagnosticControls telemetryDiagnosticControls=new TelemetryDiagnosticControls();
	@Test
     void CheckTransmission_should_send_a_diagnostic_message_and_receive_a_status_message_response()
    {


    }

    /**
     * TestChekTransmission
     */
    @Test
     void TestChekTransmission()
    {
        //Mockito.doThrow(new IllegalArgumentException()).when(telemetryClient).connect(Mockito.anyString());
        try {
            telemetryDiagnosticControls.checkTransmission();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    void TestChekTransmissionException()
    {
       // Mockito.when(telemetryClient.getOnlineStatus()).thenReturn(false);

        try {
            telemetryDiagnosticControls.checkTransmission();
            Assertions.assertNotNull(telemetryDiagnosticControls.getDiagnosticInfo());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * TestSetDiagnosticInfo
     */
    @Test
    void TestSetDiagnosticInfo()
    {
        try {
            telemetryDiagnosticControls.setDiagnosticInfo("Diagnostic Info");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * TestGetDiagnosticInfo
     */
    @Test
    void TestGetDiagnosticInfo()
    {
        try {
            String res=telemetryDiagnosticControls.getDiagnosticInfo();
            Assertions.assertNotNull(res);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


}
