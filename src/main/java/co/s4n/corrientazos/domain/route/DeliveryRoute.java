package co.s4n.corrientazos.domain.route;

import co.s4n.corrientazos.domain.drone.IDrone;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DeliveryRoute {

    private List<Step> steps;

    private DeliveryRoute(List<Step> steps) {
        this.steps = steps;
    }

    public boolean isInValid() {
        return this.steps.stream()
                .anyMatch(step -> step == Step.NONE);
    }

    public List<Step> getDeliverySteps() {
        return Collections.unmodifiableList(steps);
    }

    public static DeliveryRoute of(String steps) {

        List<Step> droneSteps = getSteps(steps);
        return new DeliveryRoute(droneSteps);
    }

    private static List<Step> getSteps(String steps) {
        return steps.chars()
                    .mapToObj(item -> (char) item)
                    .map(String::valueOf)
                    .map(Step::valueOfLabel)
                    .collect(Collectors.toList());
    }

    enum Step {
        AHEAD("A") {
            @Override
            void executeStep(IDrone drone) {
                drone.continueAHead();
            }
        }, LEFT("I") {
            @Override
            void executeStep(IDrone drone) {
                drone.turnLeft();
            }
        }, RIGHT("D") {
            @Override
            void executeStep(IDrone drone) {
                drone.turnRight();
            }
        }, NONE("NONE") {
            @Override
            void executeStep(IDrone drone) {

            }
        };

        private static final Map<String, Step> BY_LABEL = new HashMap<>();

        static {
            for (Step e: values()) {
                BY_LABEL.put(e.value, e);
            }
        }

        private String value;
        private Step(String value) {
            this.value = value;
        }

        abstract void executeStep(IDrone drone);

        public static Step valueOfLabel(String label) {
            return BY_LABEL.getOrDefault(label, NONE);
        }
    }
}
