package co.s4n.corrientazos.domain.report;

import co.s4n.corrientazos.domain.location.Location;
import co.s4n.corrientazos.domain.orientation.Cardinal;

public class DroneReport implements IDroneReport {

    private String deliveryName;
    private Location location;
    private Cardinal cardinal;

    public DroneReport(String deliveryName, Location location, Cardinal cardinal) {
        this.deliveryName = deliveryName;
        this.location = location;
        this.cardinal = cardinal;
    }

    @Override
    public String getDeliveryName() {
        return this.deliveryName;
    }

    @Override
    public String getFormattedReport() {
        return String.format("(%d, %d) %s %s",
                location.getCoordinateX(), location.getCoordinateY(), "dirección", cardinal.getValue());
    }
}
