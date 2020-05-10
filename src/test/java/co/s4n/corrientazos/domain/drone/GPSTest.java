package co.s4n.corrientazos.domain.drone;

import co.s4n.corrientazos.domain.location.Location;
import org.junit.Test;

import static org.junit.Assert.*;

public class GPSTest {

    @Test
    public void givenInitialLocationAndMove4StepsToNorth() {
        Location initial = new Location(0,0);
        GPS gps = new GPS(initial);
        gps.moveToNorth();
        gps.moveToNorth();
        gps.moveToNorth();
        gps.moveToNorth();

        Location expected = new Location(0, 4);
        assertEquals(expected, gps.getCurrentLocation());
    }
}