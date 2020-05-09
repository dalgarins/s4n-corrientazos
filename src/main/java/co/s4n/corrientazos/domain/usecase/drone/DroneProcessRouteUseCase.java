package co.s4n.corrientazos.domain.usecase.drone;

import co.s4n.corrientazos.domain.drone.Drone;
import co.s4n.corrientazos.domain.report.DroneReport;
import co.s4n.corrientazos.domain.route.DroneRoute;
import co.s4n.corrientazos.domain.route.IDroneRoute;
import co.s4n.corrientazos.domain.usecase.UseCase;

import java.util.Collections;
import java.util.List;

public class DroneProcessRouteUseCase extends UseCase<DroneProcessRouteUseCase.Request, DroneProcessRouteUseCase.Response> {

    @Override
    public Response execute(Request input) {
        return new Response(input.drone.processRoute(input.route));
    }

    public static class Request implements UseCase.InputValues {

        private final Drone drone;
        private final IDroneRoute route;

        public Request(Drone drone, DroneRoute route) {
            this.drone = drone;
            this.route = route;
        }

        public Drone getDrone() {
            return drone;
        }

        public IDroneRoute getRoute() {
            return route;
        }
    }

    public static class Response implements UseCase.OutputValues {

        private final List<DroneReport> routes;

        public Response(List<DroneReport> routes) {
            this.routes = routes;
        }

        public List<DroneReport> getReport() {
            return Collections.unmodifiableList(routes);
        }
    }
}
