package co.s4n.corrientazos.app.factory;

import co.s4n.corrientazos.app.injection.Injection;
import co.s4n.corrientazos.domain.drone.Drone;

import java.util.function.Supplier;

public class DroneFactory implements Supplier<Drone> {
    @Override
    public Drone get() {
        return new Drone(Injection.provideGps(),
                Injection.provideGyroscope(),
                Injection.provideRouteProcessor());
    }
}
