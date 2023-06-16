package tddmicroexercises.telemetrysystem;

public class TelemetryDiagnosticControls
{
    private final String DiagnosticChannelConnectionString = "*111#";
    
    private TelemetryClientInterface telemetryClient;
    private TelemetryNetworkInterface telemetryNetworkInterface;

    public void setTelemetryClient(TelemetryClientInterface telemetryClient) {
        this.telemetryClient = telemetryClient;
    }

    private String diagnosticInfo = "";

        public TelemetryDiagnosticControls()
        {
            //telemetryClient = new TelemetryClient();
        }
        
        public String getDiagnosticInfo(){
            return diagnosticInfo;
        }
        
        public void setDiagnosticInfo(String diagnosticInfo){
            this.diagnosticInfo = diagnosticInfo;
        }
 
        public void checkTransmission() throws Exception
        {
            diagnosticInfo = "";

            telemetryNetworkInterface.disconnect();
    
            int retryLeft = 3;
            while (telemetryNetworkInterface.getOnlineStatus() == false && retryLeft > 0)
            {
                telemetryNetworkInterface.connect(DiagnosticChannelConnectionString);
                retryLeft -= 1;
            }
             
            if(telemetryNetworkInterface.getOnlineStatus() == false)
            {
                throw new Exception("Unable to connect.");
            }
    
            telemetryClient.send(TelemetryClient.DIAGNOSTIC_MESSAGE);
            diagnosticInfo = telemetryClient.receive();
    }
}
