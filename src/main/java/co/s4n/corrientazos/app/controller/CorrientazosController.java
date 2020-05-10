package co.s4n.corrientazos.app.controller;

import co.s4n.corrientazos.app.factory.DroneFactory;
import co.s4n.corrientazos.domain.route.DroneRoute;
import co.s4n.corrientazos.domain.usecase.UseCaseExecutor;
import co.s4n.corrientazos.domain.usecase.drone.DroneProcessRouteUseCase;
import co.s4n.corrientazos.domain.usecase.route.GetAllRoutesUseCase;
import co.s4n.corrientazos.domain.usecase.route.WriteReportByDroneUseCase;
import com.spotify.futures.CompletableFutures;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public class CorrientazosController implements IDeliveryController {

    private UseCaseExecutor useCaseExecutor;
    private GetAllRoutesUseCase getAllRoutesUseCase;
    private DroneProcessRouteUseCase droneProcessRouteUseCase;
    private WriteReportByDroneUseCase writeReportByDroneUseCase;
    private DroneFactory droneFactory;

    public CorrientazosController(UseCaseExecutor useCaseExecutor,
                                  GetAllRoutesUseCase getAllRoutesUseCase,
                                  DroneProcessRouteUseCase droneProcessRouteUseCase,
                                  WriteReportByDroneUseCase writeReportByDroneUseCase,
                                  DroneFactory droneFactory) {
        this.useCaseExecutor = useCaseExecutor;
        this.getAllRoutesUseCase = getAllRoutesUseCase;
        this.droneProcessRouteUseCase = droneProcessRouteUseCase;
        this.writeReportByDroneUseCase = writeReportByDroneUseCase;
        this.droneFactory = droneFactory;
    }

    @Override
    public void startDelivery() {

        CompletableFuture.allOf(
            getAllRoutes()
            .thenCompose(this::processAllRoutes)
            .thenAccept(this::writeAllOutputReports)
        ).join();
    }

    private CompletableFuture<List<DroneRoute>> getAllRoutes() {
        return this.useCaseExecutor.execute(
            getAllRoutesUseCase,
            new GetAllRoutesUseCase.Request(),
            GetAllRoutesUseCase.Response::getRoutes
        );
    }

    private CompletableFuture<List<DroneProcessRouteUseCase.Response>> processAllRoutes(List<DroneRoute> routes) {
        return routes.stream()
            .map(droneRoute -> useCaseExecutor.execute(
                droneProcessRouteUseCase,
                new DroneProcessRouteUseCase.Request(droneFactory.get(), droneRoute),
                Function.identity()
            )).collect(CompletableFutures.joinList());
    }

    private void writeAllOutputReports(List<DroneProcessRouteUseCase.Response> reports) {
        reports.forEach(iDroneReports -> useCaseExecutor.execute(
                writeReportByDroneUseCase,
                new WriteReportByDroneUseCase.Request(iDroneReports.getReport()),
                Function.identity()));
    }
}
