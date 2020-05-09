package co.s4n.corrientazos.domain.drone;

import co.s4n.corrientazos.domain.location.Location;
import co.s4n.corrientazos.domain.orientation.Cardinal;
import co.s4n.corrientazos.domain.report.DroneReport;
import co.s4n.corrientazos.domain.route.IDroneRoute;

import java.util.List;

public class Drone {

    private Location droneLocation;
    private Cardinal cardinalPoint;

    public Drone(Location droneLocation, Cardinal cardinalPoint) {
        this.droneLocation = droneLocation;
        this.cardinalPoint = cardinalPoint;
    }

    public List<DroneReport> processRoute(IDroneRoute route) {
        return null;
    }
}
