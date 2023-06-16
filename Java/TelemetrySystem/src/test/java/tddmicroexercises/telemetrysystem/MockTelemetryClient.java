package tddmicroexercises.telemetrysystem;

public class MockTelemetryClient implements TelemetryClientInterface {
    private boolean isOnline;
    private String diagnosticInfo;
    private boolean isSendCalled;
    private boolean isReceiveCalled;
    private int connectionAttempts;

    @Override
    public boolean getOnlineStatus() {
        return isOnline;
    }

    @Override
    public void connect(String connectionString) {
        connectionAttempts++;
        if (connectionAttempts <= 3) {
            isOnline = true;
        } else {
            isOnline = false;
        }
    }

    @Override
    public void disconnect() {
        isOnline = false;
    }

    @Override
    public void send(String message) {
        isSendCalled = true;
    }

    @Override
    public String receive() {
        isReceiveCalled = true;
        return diagnosticInfo;
    }

    public void setOnlineStatus(boolean isOnline) {
        this.isOnline = isOnline;
    }

    public void setDiagnosticInfo(String diagnosticInfo) {
        this.diagnosticInfo = diagnosticInfo;
    }

    public boolean isSendCalled() {
        return isSendCalled;
    }

    public boolean isReceiveCalled() {
        return isReceiveCalled;
    }

    public int getConnectionAttempts() {
        return connectionAttempts;
    }
}