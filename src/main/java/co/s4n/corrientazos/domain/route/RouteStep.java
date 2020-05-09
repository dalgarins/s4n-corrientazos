package co.s4n.corrientazos.domain.route;

import co.s4n.corrientazos.domain.drone.IDrone;

import java.util.HashMap;
import java.util.Map;

public enum RouteStep {
    AHEAD("A") {
        @Override
        public void executeStep(IDrone drone) {
            drone.continueAHead();
        }
    }, LEFT("I") {
        @Override
        public void executeStep(IDrone drone) {
            drone.turnLeft();
        }
    }, RIGHT("D") {
        @Override
        public void executeStep(IDrone drone) {
            drone.turnRight();
        }
    }, NONE("NONE") {
        @Override
        public void executeStep(IDrone drone) {

        }
    };

    private static final Map<String, RouteStep> BY_LABEL = new HashMap<>();

    static {
        for (RouteStep e: values()) {
            BY_LABEL.put(e.value, e);
        }
    }

    private String value;
    private RouteStep(String value) {
        this.value = value;
    }

    public abstract void executeStep(IDrone drone);

    public static RouteStep valueOfLabel(String label) {
        return BY_LABEL.getOrDefault(label, NONE);
    }
}
