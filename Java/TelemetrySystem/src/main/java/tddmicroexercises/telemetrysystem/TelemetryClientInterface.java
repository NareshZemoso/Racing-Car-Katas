package tddmicroexercises.telemetrysystem;

public interface TelemetryClientInterface {

    void send(String message);
    String receive();
}
