package co.s4n.corrientazos.domain.route;

import java.util.Collections;
import java.util.List;

public class DeliveryRoute {

    private List<Step> steps;

    public DeliveryRoute(List<Step> steps) {
        this.steps = steps;
    }

    public List<Step> getDeliverySteps() {
        return Collections.unmodifiableList(steps);
    }

    enum Step {
        AHEAD("A"), LEFT("I"), RIGHT("D");

        private String value;
        private Step(String value) {
            this.value = value;
        }
    }
}
