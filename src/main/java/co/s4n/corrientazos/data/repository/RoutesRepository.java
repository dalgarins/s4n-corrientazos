package co.s4n.corrientazos.data.repository;

import co.s4n.corrientazos.domain.report.IDroneReport;
import co.s4n.corrientazos.domain.report.IWriteReport;
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
import java.util.Optional;
import java.util.stream.Collectors;

public class RoutesRepository implements IInputRepository, IOutputRepository {

    private String inputPath;
    private IWriteReport writeReport;

    public RoutesRepository(String inputPath, IWriteReport writeReport) {
        this.inputPath = inputPath;
        this.writeReport = writeReport;
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
                    .map(steps -> DeliveryRoute.of(routePath.getFileName().toString(), steps))
                    .collect(Collectors.toList()));
        }).orElse(new DroneRoute(new ArrayList<>()));
    }

    @Override
    public void saveDroneReports(List<IDroneReport> reports) {

        String report = reports.stream()
                .findFirst()
                .map(IDroneReport::getDeliveryName)
                .map(name -> name.replace("in", "out"))
                .orElse("");

        writeReport.writeReport(report, reports);

    }
}
