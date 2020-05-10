package co.s4n.corrientazos.domain.drone;

import co.s4n.corrientazos.domain.location.Location;
import co.s4n.corrientazos.domain.orientation.Cardinal;
import co.s4n.corrientazos.domain.processors.DroneLinearProcessor;
import co.s4n.corrientazos.domain.report.DroneReport;
import co.s4n.corrientazos.domain.report.IDroneReport;
import co.s4n.corrientazos.domain.report.InvalidReport;
import co.s4n.corrientazos.domain.route.DeliveryRoute;
import co.s4n.corrientazos.domain.route.DroneRoute;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class DroneTest {

    public static final String IN_01_TXT = "in01.txt";

    @Test
    public void givenARouteDroneProcessAllRoute() {

        Location initialLocation = new Location(0, 0);
        Drone drone = new Drone(new GPS(initialLocation), new Gyroscope(), new DroneLinearProcessor());

        List<DeliveryRoute> routes = getDeliveryRoutes();
        DroneRoute route = new DroneRoute(routes);

        List<IDroneReport> reports = drone.processRoute(route);
        List<IDroneReport> expected = getExpectedDeliveryReports();

        assertEquals(expected, reports);
    }

    private List<IDroneReport> getExpectedDeliveryReports() {

        DroneReport droneReport1 = new DroneReport(IN_01_TXT, new Location(1,3), Cardinal.EAST);
        DroneReport droneReport2 = new DroneReport(IN_01_TXT, new Location(2, 6), Cardinal.NORTH);

        return Arrays.asList(droneReport1, droneReport2);
    }

    private List<DeliveryRoute> getDeliveryRoutes() {

        DeliveryRoute deliveryRoute1 = DeliveryRoute.of(IN_01_TXT, "AAADA");
        DeliveryRoute deliveryRoute2 = DeliveryRoute.of(IN_01_TXT, "AIAAA");
        return Arrays.asList(deliveryRoute1, deliveryRoute2);
    }

    @Test
    public void givenARouteDroneWithAnInvalidRouteNoProcessRoutes() {

        Location initialLocation = new Location(0, 0);
        Drone drone = new Drone(new GPS(initialLocation), new Gyroscope(), new DroneLinearProcessor());

        List<DeliveryRoute> routes = getInvalidDeliveryRoutes();
        DroneRoute route = new DroneRoute(routes);

        List<IDroneReport> reports = drone.processRoute(route);
        List<IDroneReport> expected = getExpectedInvalidDeliveryRoutes();

        assertEquals(expected, reports);
    }

    private List<IDroneReport> getExpectedInvalidDeliveryRoutes() {

        InvalidReport deliveryRoute1 = new InvalidReport(IN_01_TXT);
        return Arrays.asList(deliveryRoute1);
    }

    private List<DeliveryRoute> getInvalidDeliveryRoutes() {

        DeliveryRoute deliveryRoute1 = DeliveryRoute.of(IN_01_TXT, "AAADA");
        DeliveryRoute deliveryRoute2 = DeliveryRoute.of(IN_01_TXT, "AIAAAXY");
        return Arrays.asList(deliveryRoute1, deliveryRoute2);
    }
}