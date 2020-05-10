package co.s4n.corrientazos.data.repository;

import co.s4n.corrientazos.domain.location.Location;
import co.s4n.corrientazos.domain.orientation.Cardinal;
import co.s4n.corrientazos.domain.report.DroneReport;
import co.s4n.corrientazos.domain.report.IDroneReport;
import co.s4n.corrientazos.domain.report.IWriteReport;
import co.s4n.corrientazos.domain.repository.IInputRepository;
import co.s4n.corrientazos.domain.repository.IOutputRepository;
import co.s4n.corrientazos.domain.route.DroneRoute;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class RoutesRepositoryTest {

    @Test
    public void givenAPathWithEmptyTextRoutesReturnListEmptyDroneRoutes() {
        IWriteReport writeReport = Mockito.mock(IWriteReport.class);

        IInputRepository inputRepository = new RoutesRepository("input_empty/", writeReport);
        List<DroneRoute> droneRoutes = inputRepository.getDroneRoutes();
        assertTrue(droneRoutes.isEmpty());
    }

    @Test
    public void givenAPathWithTextRoutesReturnListDroneRoutes() {
        IWriteReport writeReport = Mockito.mock(IWriteReport.class);

        IInputRepository inputRepository = new RoutesRepository("input_test/", writeReport);
        List<DroneRoute> droneRoutes = inputRepository.getDroneRoutes();
        assertFalse(droneRoutes.isEmpty());
    }

    @Test
    public void givenListDroneReportsCreateOutputReports() {
        IWriteReport writeReport = Mockito.mock(IWriteReport.class);
        IOutputRepository outputRepository = new RoutesRepository("input_test/", writeReport);

        List<IDroneReport> reports = getReports();

        outputRepository.saveDroneReports(reports);
        verify(writeReport).writeReport("out01.txt", reports);
    }

    private List<IDroneReport> getReports() {
        IDroneReport report = new DroneReport("in01.txt", new Location(4,2), Cardinal.EAST);
        return Arrays.asList(report);
    }
}