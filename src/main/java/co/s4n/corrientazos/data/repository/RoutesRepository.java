package co.s4n.corrientazos.data.repository;

import co.s4n.corrientazos.domain.report.DroneReport;
import co.s4n.corrientazos.domain.repository.IInputRepository;
import co.s4n.corrientazos.domain.repository.IOutputRepository;
import co.s4n.corrientazos.domain.route.DeliveryRoute;
import co.s4n.corrientazos.domain.route.DroneRoute;
import com.jasongoodwin.monads.Try;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RoutesRepository implements IInputRepository, IOutputRepository {

    private String inputPath;
    private String outputPath;

    public RoutesRepository(String inputPath, String outputPath) {
        this.inputPath = inputPath;
        this.outputPath = outputPath;
    }

    @Override
    public List<DroneRoute> getDroneRoutes() {
        return Try.ofFailable(() -> {
            return Files.list(Paths.get(inputPath))
                    .map(this::getDroneRoute)
                    .collect(Collectors.toList());
        }).orElse(new ArrayList<>());
    }

    private DroneRoute getDroneRoute(Path routePath) {
        return Try.ofFailable(() -> {
            return new DroneRoute(Files.lines(routePath)
                    .map(DeliveryRoute::of)
                    .collect(Collectors.toList()));
        }).orElse(new DroneRoute(new ArrayList<>()));
    }

    @Override
    public void saveDroneReports(List<DroneReport> reports) {

    }
}
