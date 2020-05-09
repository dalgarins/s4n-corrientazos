package co.s4n.corrientazos.domain.route;

import java.util.Collections;
import java.util.List;

public class DroneRoute implements IDroneRoute {

    private List<DeliveryRoute> routes;

    public DroneRoute(List<DeliveryRoute> routes) {
        this.routes = routes;
    }

    public void addRoute(DeliveryRoute route) {
        this.routes.add(route);
    }

    @Override
    public List<DeliveryRoute> getRoutes() {
        return Collections.unmodifiableList(routes);
    }
}
