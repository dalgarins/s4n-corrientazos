package co.s4n.corrientazos.domain.drone;

import co.s4n.corrientazos.domain.location.Location;
import co.s4n.corrientazos.domain.orientation.Cardinal;
import co.s4n.corrientazos.domain.route.DroneRoute;

public class Drone {

    private Location droneLocation;
    private Cardinal cardinalPoint;
    private DroneRoute deliveryRoute;

    public Drone(Location droneLocation, Cardinal cardinalPoint, DroneRoute deliveryRoute) {
        this.droneLocation = droneLocation;
        this.cardinalPoint = cardinalPoint;
        this.deliveryRoute = deliveryRoute;
    }
}
