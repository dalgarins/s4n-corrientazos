package co.s4n.corrientazos.domain.route;

import java.util.List;

public interface IDroneRoute {

    String getRouteName();

    List<DeliveryRoute> getRoutes();

    boolean hasAnInvalidRoute();

}
