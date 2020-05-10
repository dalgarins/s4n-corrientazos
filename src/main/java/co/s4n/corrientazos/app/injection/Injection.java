package co.s4n.corrientazos.app.injection;

import co.s4n.corrientazos.app.executor.UseCaseExecutorImpl;
import co.s4n.corrientazos.app.factory.DroneFactory;
import co.s4n.corrientazos.data.repository.RoutesRepository;
import co.s4n.corrientazos.domain.drone.GPS;
import co.s4n.corrientazos.domain.drone.Gyroscope;
import co.s4n.corrientazos.domain.gps.IGeoPosition;
import co.s4n.corrientazos.domain.location.Location;
import co.s4n.corrientazos.domain.orientation.IGyroscope;
import co.s4n.corrientazos.domain.processors.DroneLinearProcessor;
import co.s4n.corrientazos.domain.processors.IRouteProcessor;
import co.s4n.corrientazos.domain.repository.IInputRepository;
import co.s4n.corrientazos.domain.repository.IOutputRepository;
import co.s4n.corrientazos.domain.usecase.UseCaseExecutor;
import co.s4n.corrientazos.domain.usecase.drone.DroneProcessRouteUseCase;
import co.s4n.corrientazos.domain.usecase.route.GetAllRoutesUseCase;
import co.s4n.corrientazos.domain.usecase.route.WriteReportByDroneUseCase;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Injection {

    private Injection() {}

    private static class SINGLETON_HELPER {

        private static int INITIAL_COORDINATE_X = 0;
        private static int INITIAL_COORDINATE_Y = 0;
        private static Executor EXECUTOR = Executors.newCachedThreadPool();
        private static UseCaseExecutor USE_CASE_EXECUTOR = new UseCaseExecutorImpl(EXECUTOR);
        private static IRouteProcessor ROUTE_PROCESSOR = new DroneLinearProcessor();
        private static DroneFactory DRONE_FACTORY = new DroneFactory();

    }

    public static DroneFactory provideDroneFactory() {
        return SINGLETON_HELPER.DRONE_FACTORY;
    }

    private static Location provideDefaultLocation() {
        return new Location(SINGLETON_HELPER.INITIAL_COORDINATE_X, SINGLETON_HELPER.INITIAL_COORDINATE_Y);
    }

    public static IGeoPosition provideGps() {
        return new GPS(provideDefaultLocation());
    }

    public static IGyroscope provideGyroscope() {
        return new Gyroscope();
    }

    public static IRouteProcessor provideRouteProcessor() {
        return SINGLETON_HELPER.ROUTE_PROCESSOR;
    }

    public static UseCaseExecutor provideUseCaseExecutor() {
        return SINGLETON_HELPER.USE_CASE_EXECUTOR;
    }

    public static RoutesRepository provideInputRepository(String inputPath, String outputPath) {
        return new RoutesRepository(inputPath, outputPath);
    }

    public static GetAllRoutesUseCase provideGetAllRoutesUseCase(IInputRepository inputRepository) {
        return new GetAllRoutesUseCase(inputRepository);
    }

    public static DroneProcessRouteUseCase provideDroneProcessRouteUseCase() {
        return new DroneProcessRouteUseCase();
    }

    public static WriteReportByDroneUseCase provideWriteReportByDroneUseCase(IOutputRepository outputRepository) {
        return new WriteReportByDroneUseCase(outputRepository);
    }

}
