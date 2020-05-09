package co.s4n.corrientazos.domain.repository;

import co.s4n.corrientazos.domain.route.DroneRoute;

import java.util.List;

public interface IInputRepository {

    List<DroneRoute> getDroneRoutes();

}
