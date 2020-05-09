package co.s4n.corrientazos.domain.route;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DeliveryRouteTest {

    @Test
    public void givenAValidStringReturnValidListSteps() {

        List<RouteStep> steps = new ArrayList<>();
        steps.add(RouteStep.AHEAD);
        steps.add(RouteStep.AHEAD);
        steps.add(RouteStep.AHEAD);
        steps.add(RouteStep.AHEAD);
        steps.add(RouteStep.AHEAD);
        steps.add(RouteStep.LEFT);
        steps.add(RouteStep.RIGHT);

        DeliveryRoute deliveryRoute = DeliveryRoute.of("AAAAAID");
        assertNotNull(deliveryRoute);
        assertEquals(deliveryRoute.getDeliverySteps(), steps);
    }

    @Test
    public void givenAnInvalidStringReturnInvalidStepList() {

        DeliveryRoute deliveryRoute = DeliveryRoute.of("XYZ");
        assertTrue(deliveryRoute.isInValid());
    }
}