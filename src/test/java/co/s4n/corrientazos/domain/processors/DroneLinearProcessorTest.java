package co.s4n.corrientazos.domain.processors;

import co.s4n.corrientazos.domain.drone.Drone;
import co.s4n.corrientazos.domain.drone.GPS;
import co.s4n.corrientazos.domain.drone.Gyroscope;
import co.s4n.corrientazos.domain.drone.IDrone;
import co.s4n.corrientazos.domain.location.Location;
import co.s4n.corrientazos.domain.orientation.Cardinal;
import co.s4n.corrientazos.domain.report.DroneReport;
import co.s4n.corrientazos.domain.report.IDroneReport;
import co.s4n.corrientazos.domain.report.InvalidReport;
import co.s4n.corrientazos.domain.route.DeliveryRoute;
import co.s4n.corrientazos.domain.route.IDroneRoute;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DroneLinearProcessorTest {

    public static final String TEXT_ROUTE = "text_route";
    public static final String INPUT_01 = "in01.txt";

    @Test
    public void processAllRoutesWithAnInvalidRoute() {
        IDrone drone = mock(IDrone.class);
        IDroneRoute droneRoute = mock(IDroneRoute.class);

        when(droneRoute.getRouteName()).thenReturn(TEXT_ROUTE);
        when(droneRoute.hasAnInvalidRoute()).thenReturn(true);

        DroneLinearProcessor processor = new DroneLinearProcessor();
        List<IDroneReport> droneReports = processor.process(drone, droneRoute);

        List<IDroneReport> expected = Collections.singletonList(new InvalidReport(TEXT_ROUTE));

        assertEquals(expected, droneReports);
    }

    @Test
    public void processAllRoutesForADrone() {

        IDrone drone = new Drone(new GPS(new Location(0,0)),
                new Gyroscope(),
                new DroneLinearProcessor());
        IDroneRoute droneRoute = mock(IDroneRoute.class);

        when(droneRoute.getRouteName()).thenReturn(INPUT_01);
        when(droneRoute.hasAnInvalidRoute()).thenReturn(false);

        when(droneRoute.getRoutes())
                .thenReturn(makeSquarePath());

        DroneLinearProcessor processor = new DroneLinearProcessor();
        List<IDroneReport> droneReports = processor.process(drone, droneRoute);

        List<IDroneReport> expected = getExpectedDroneReport();

        assertEquals(expected, droneReports);
    }

    private List<IDroneReport> getExpectedDroneReport() {

        DroneReport droneReport1 = new DroneReport(INPUT_01, new Location(0, 4), Cardinal.NORTH);
        DroneReport droneReport2 = new DroneReport(INPUT_01, new Location(-4, 4), Cardinal.WEST);
        DroneReport droneReport3 = new DroneReport(INPUT_01, new Location(-4, 0), Cardinal.SOUTH);
        DroneReport droneReport4 = new DroneReport(INPUT_01, new Location(0, 0), Cardinal.EAST);

        return Arrays.asList(droneReport1, droneReport2, droneReport3, droneReport4);
    }

    private List<DeliveryRoute> makeSquarePath() {

        DeliveryRoute route1 = DeliveryRoute.of(INPUT_01, "AAAA");
        DeliveryRoute route2 = DeliveryRoute.of(INPUT_01, "IAAAA");
        DeliveryRoute route3 = DeliveryRoute.of(INPUT_01, "IAAAA");
        DeliveryRoute route4 = DeliveryRoute.of(INPUT_01, "IAAAA");

        return Arrays.asList(route1, route2, route3, route4);
    }

}