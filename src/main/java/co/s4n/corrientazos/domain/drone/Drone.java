package co.s4n.corrientazos.domain.drone;

import co.s4n.corrientazos.domain.gps.IGeoPosition;
import co.s4n.corrientazos.domain.orientation.IGyroscope;
import co.s4n.corrientazos.domain.processors.IRouteProcessor;
import co.s4n.corrientazos.domain.report.IDroneReport;
import co.s4n.corrientazos.domain.route.IDroneRoute;

import java.util.List;

public class Drone implements IDrone {

    private IGeoPosition geoPosition;
    private IGyroscope gyroscope;
    private IRouteProcessor routeProcessor;

    public Drone(IGeoPosition geoPosition,
                 IGyroscope gyroscope,
                 IRouteProcessor routeProcessor) {
        this.geoPosition = geoPosition;
        this.gyroscope = gyroscope;
        this.routeProcessor = routeProcessor;
    }

    public List<IDroneReport> processRoute(IDroneRoute route) {
        return routeProcessor.process(this, route);
    }

    @Override
    public void turnLeft() {
        gyroscope.turnLeft();
    }

    @Override
    public void turnRight() {
        gyroscope.turnRight();
    }

    @Override
    public void continueAHead() {
        geoPosition.updateLocation(gyroscope.targetCardinalPoint());
    }

    @Override
    public IDroneReport getReport() {
        return null;
    }
}
