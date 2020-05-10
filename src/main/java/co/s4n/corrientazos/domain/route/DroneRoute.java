package co.s4n.corrientazos.domain.route;

import java.util.Collections;
import java.util.List;

public class DroneRoute implements IDroneRoute {

    private List<DeliveryRoute> routes;

    public DroneRoute(List<DeliveryRoute> routes) {
        this.routes = routes;
    }

    @Override
    public String getRouteName() {
        return this.routes.stream()
                .findFirst()
                .map(DeliveryRoute::getDeliveryName)
                .orElseGet(() -> "");
    }

    @Override
    public List<DeliveryRoute> getRoutes() {
        return Collections.unmodifiableList(routes);
    }

    @Override
    public boolean hasAnInvalidRoute() {
        return this.getRoutes().stream()
                .anyMatch(DeliveryRoute::isInValid);
    }
}
