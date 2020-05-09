package co.s4n.corrientazos.data.repository;

import co.s4n.corrientazos.domain.repository.IInputRepository;
import co.s4n.corrientazos.domain.route.DroneRoute;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RoutesRepositoryTest {

    @Test
    public void givenAPathWithEmptyTextRoutesReturnListEmptyDroneRoutes() {

        IInputRepository inputRepository = new RoutesRepository("input_empty/", "");
        List<DroneRoute> droneRoutes = inputRepository.getDroneRoutes();
        assertTrue(droneRoutes.isEmpty());
    }

    @Test
    public void givenAPathWithTextRoutesReturnListDroneRoutes() {

        IInputRepository inputRepository = new RoutesRepository("input_test/", "");
        List<DroneRoute> droneRoutes = inputRepository.getDroneRoutes();
        assertFalse(droneRoutes.isEmpty());
    }

}