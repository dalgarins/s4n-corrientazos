package co.s4n.corrientazos.domain.processors;

import co.s4n.corrientazos.domain.drone.IDrone;
import co.s4n.corrientazos.domain.report.IDroneReport;
import co.s4n.corrientazos.domain.report.InvalidReport;
import co.s4n.corrientazos.domain.route.DeliveryRoute;
import co.s4n.corrientazos.domain.route.IDroneRoute;
import co.s4n.corrientazos.domain.route.RouteStep;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DroneLinearProcessor implements IRouteProcessor {
    @Override
    public List<IDroneReport> process(IDrone drone, IDroneRoute routes) {
        if (routes.hasAnInvalidRoute()) {
            return Collections.singletonList(new InvalidReport(routes.getRouteName()));
        }
        return routes.getRoutes()
                .stream()
                .map(processRoute(drone))
                .collect(Collectors.toList());
    }

    private Function<DeliveryRoute, IDroneReport> processRoute(IDrone drone) {
        return deliveryRoute -> processDelivery(drone, deliveryRoute);
    }

    private IDroneReport processDelivery(IDrone drone, DeliveryRoute deliveryRoute) {
        deliveryRoute.getDeliverySteps()
                .forEach((RouteStep step) -> step.executeStep(drone));
        return drone.getReport(deliveryRoute);
    }
}
