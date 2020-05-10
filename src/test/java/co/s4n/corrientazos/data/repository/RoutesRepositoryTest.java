package co.s4n.corrientazos.data.repository;

import co.s4n.corrientazos.domain.report.IWriteReport;
import co.s4n.corrientazos.domain.repository.IInputRepository;
import co.s4n.corrientazos.domain.route.DroneRoute;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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

}