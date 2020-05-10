package co.s4n.corrientazos.domain.drone;

import co.s4n.corrientazos.domain.orientation.Cardinal;
import co.s4n.corrientazos.domain.orientation.EastState;
import co.s4n.corrientazos.domain.orientation.NorthState;
import co.s4n.corrientazos.domain.orientation.SouthState;
import co.s4n.corrientazos.domain.orientation.WestState;
import org.junit.Test;

import static org.junit.Assert.*;

public class GyroscopeTest {

    @Test
    public void givenGyroscopeWithNorthOrientationChange90DegreesToLeft() {

        Gyroscope gyroscope = new Gyroscope();
        gyroscope.setCardinalState(new NorthState());
        gyroscope.turnLeft();

        assertEquals(Cardinal.WEST, gyroscope.targetCardinalPoint());
    }

    @Test
    public void givenGyroscopeWithNorthOrientationChange90DegreesToRight() {

        Gyroscope gyroscope = new Gyroscope();
        gyroscope.setCardinalState(new NorthState());
        gyroscope.turnRight();

        assertEquals(Cardinal.EAST, gyroscope.targetCardinalPoint());
    }

    @Test
    public void givenGyroscopeWithEastOrientationChange90DegreesToLeft() {

        Gyroscope gyroscope = new Gyroscope();
        gyroscope.setCardinalState(new EastState());
        gyroscope.turnLeft();

        assertEquals(Cardinal.NORTH, gyroscope.targetCardinalPoint());
    }

    @Test
    public void givenGyroscopeWithEastOrientationChange90DegreesToRight() {

        Gyroscope gyroscope = new Gyroscope();
        gyroscope.setCardinalState(new EastState());
        gyroscope.turnRight();

        assertEquals(Cardinal.SOUTH, gyroscope.targetCardinalPoint());
    }

    @Test
    public void givenGyroscopeWithSouthOrientationChange90DegreesToLeft() {

        Gyroscope gyroscope = new Gyroscope();
        gyroscope.setCardinalState(new SouthState());
        gyroscope.turnLeft();

        assertEquals(Cardinal.EAST, gyroscope.targetCardinalPoint());
    }

    @Test
    public void givenGyroscopeWithSouthOrientationChange90DegreesToRight() {

        Gyroscope gyroscope = new Gyroscope();
        gyroscope.setCardinalState(new SouthState());
        gyroscope.turnRight();

        assertEquals(Cardinal.WEST, gyroscope.targetCardinalPoint());
    }

    @Test
    public void givenGyroscopeWithWestOrientationChange90DegreesToLeft() {

        Gyroscope gyroscope = new Gyroscope();
        gyroscope.setCardinalState(new WestState());
        gyroscope.turnLeft();

        assertEquals(Cardinal.SOUTH, gyroscope.targetCardinalPoint());
    }

    @Test
    public void givenGyroscopeWithWestOrientationChange90DegreesToRight() {

        Gyroscope gyroscope = new Gyroscope();
        gyroscope.setCardinalState(new WestState());
        gyroscope.turnRight();

        assertEquals(Cardinal.NORTH, gyroscope.targetCardinalPoint());
    }
}