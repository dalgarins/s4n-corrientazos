package co.s4n.corrientazos.domain.drone;

import co.s4n.corrientazos.domain.gps.IGeoPosition;
import co.s4n.corrientazos.domain.gps.IMovePosition;
import co.s4n.corrientazos.domain.location.Location;
import co.s4n.corrientazos.domain.orientation.Cardinal;

public class GPS implements IGeoPosition, IMovePosition {

    private Location location;

    public GPS(Location location) {
        this.location = location;
    }

    @Override
    public void updateLocation(Cardinal pointCardinal) {
        pointCardinal.updateLocation(this);
    }

    @Override
    public Location getCurrentLocation() {
        return null;
    }

    @Override
    public void moveToNorth() {
        location.increaseY();
    }

    @Override
    public void moveToSouth() {
        location.decreaseY();
    }

    @Override
    public void moveToEast() {
        location.increaseX();
    }

    @Override
    public void moveToWest() {
        location.decreaseX();
    }
}
