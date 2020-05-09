package co.s4n.corrientazos.domain.route;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DeliveryRouteTest {

    @Test
    public void givenAValidStringReturnValidListSteps() {

        List<DeliveryRoute.Step> steps = new ArrayList<>();
        steps.add(DeliveryRoute.Step.AHEAD);
        steps.add(DeliveryRoute.Step.AHEAD);
        steps.add(DeliveryRoute.Step.AHEAD);
        steps.add(DeliveryRoute.Step.AHEAD);
        steps.add(DeliveryRoute.Step.AHEAD);
        steps.add(DeliveryRoute.Step.LEFT);
        steps.add(DeliveryRoute.Step.RIGHT);

        DeliveryRoute deliveryRoute = DeliveryRoute.of("AAAAAID");
        assertNotNull(deliveryRoute);
        assertEquals(deliveryRoute.getDeliverySteps(), steps);
    }

    @Test
    public void givenAnInvalidStringReturnInvalidStepList() {

        DeliveryRoute deliveryRoute = DeliveryRoute.of("XYZ");
        deliveryRoute.getDeliverySteps().forEach(step -> {
            assertEquals(step, DeliveryRoute.Step.NONE);
        });
    }
}