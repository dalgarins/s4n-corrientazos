package co.s4n.corrientazos.domain.route;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DeliveryRoute {

    private String deliveryName;
    private List<RouteStep> steps;

    private DeliveryRoute(String deliveryName, List<RouteStep> steps) {
        this.deliveryName = deliveryName;
        this.steps = steps;
    }

    public String getDeliveryName() {
        return deliveryName;
    }

    public boolean isInValid() {
        return this.steps.stream()
                .anyMatch(step -> step == RouteStep.NONE);
    }

    public List<RouteStep> getDeliverySteps() {
        return Collections.unmodifiableList(steps);
    }

    public static DeliveryRoute of(String fileName, String steps) {

        List<RouteStep> droneSteps = getSteps(steps);
        return new DeliveryRoute(fileName, droneSteps);
    }

    private static List<RouteStep> getSteps(String steps) {
        return steps.chars()
                    .mapToObj(item -> (char) item)
                    .map(String::valueOf)
                    .map(RouteStep::valueOfLabel)
                    .collect(Collectors.toList());
    }
}
