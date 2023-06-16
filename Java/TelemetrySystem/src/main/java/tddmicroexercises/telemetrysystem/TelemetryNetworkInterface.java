package tddmicroexercises.telemetrysystem;

public interface TelemetryNetworkInterface {

    boolean getOnlineStatus();
    void connect(String connectionString);
    void disconnect();
}
