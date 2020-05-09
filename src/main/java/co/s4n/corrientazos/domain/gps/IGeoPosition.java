package co.s4n.corrientazos.domain.gps;

import co.s4n.corrientazos.domain.location.Location;
import co.s4n.corrientazos.domain.orientation.Cardinal;

public interface IGeoPosition {

    void updateLocation(Cardinal pointCardinal);

    Location getCurrentLocation();

}
