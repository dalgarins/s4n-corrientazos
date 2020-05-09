package co.s4n.corrientazos.domain.route;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DeliveryRoute {

    private List<RouteStep> steps;

    private DeliveryRoute(List<RouteStep> steps) {
        this.steps = steps;
    }

    public boolean isInValid() {
        return this.steps.stream()
                .anyMatch(step -> step == RouteStep.NONE);
    }

    public List<RouteStep> getDeliverySteps() {
        return Collections.unmodifiableList(steps);
    }

    public static DeliveryRoute of(String steps) {

        List<RouteStep> droneSteps = getSteps(steps);
        return new DeliveryRoute(droneSteps);
    }

    private static List<RouteStep> getSteps(String steps) {
        return steps.chars()
                    .mapToObj(item -> (char) item)
                    .map(String::valueOf)
                    .map(RouteStep::valueOfLabel)
                    .collect(Collectors.toList());
    }
}
