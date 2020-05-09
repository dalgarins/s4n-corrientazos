package co.s4n.corrientazos.domain.usecase.route;

import co.s4n.corrientazos.domain.repository.IInputRepository;
import co.s4n.corrientazos.domain.route.DroneRoute;
import co.s4n.corrientazos.domain.usecase.UseCase;

import java.util.Collections;
import java.util.List;

public class GetAllRoutesUseCase extends UseCase<GetAllRoutesUseCase.Request, GetAllRoutesUseCase.Response> {

    private IInputRepository repository;

    public GetAllRoutesUseCase(IInputRepository repository) {
        this.repository = repository;
    }

    @Override
    public Response execute(Request input) {
        return new Response(this.repository.getDroneRoutes());
    }

    public static class Request implements UseCase.InputValues {

    }

    public static class Response implements UseCase.OutputValues {

        private final List<DroneRoute> routes;

        public Response(List<DroneRoute> routes) {
            this.routes = routes;
        }

        public List<DroneRoute> getRoutes() {
            return Collections.unmodifiableList(routes);
        }
    }

}
