package tddmicroexercises.telemetrysystem;

public interface TelemetryClientInterface {
    boolean getOnlineStatus();
    void connect(String connectionString);
    void disconnect();
    void send(String message);
    String receive();
}
