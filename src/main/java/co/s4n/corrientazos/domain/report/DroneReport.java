package co.s4n.corrientazos.domain.report;

import co.s4n.corrientazos.domain.location.Location;
import co.s4n.corrientazos.domain.orientation.Cardinal;

public class DroneReport implements IDroneReport {

    private Location location;
    private Cardinal cardinal;

    public DroneReport(Location location, Cardinal cardinal) {
        this.location = location;
        this.cardinal = cardinal;
    }

    @Override
    public String getFormattedReport() {
        return String.format("(%d, %d) %s %s",
                location.getCoordinateX(), location.getCoordinateY(), "dirección", cardinal.getValue());
    }
}
