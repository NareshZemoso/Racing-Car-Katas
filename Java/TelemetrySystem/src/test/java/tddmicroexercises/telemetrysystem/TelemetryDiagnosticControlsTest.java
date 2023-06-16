package tddmicroexercises.telemetrysystem;

import org.junit.jupiter.api.Test;

 class TelemetryDiagnosticControlsTest
{

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
        try {
            telemetryDiagnosticControls.checkTransmission();
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
            telemetryDiagnosticControls.getDiagnosticInfo();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


}
