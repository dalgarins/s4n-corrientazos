package co.s4n.corrientazos.domain.report;

import co.s4n.corrientazos.domain.drone.Drone;
import co.s4n.corrientazos.domain.location.Location;
import co.s4n.corrientazos.domain.orientation.Cardinal;
import org.junit.Test;

import static org.junit.Assert.*;

public class DroneReportTest {

    @Test
    public void givenADroneReportReturnFormattedValue() {
        IDroneReport valid = new DroneReport("valid",
                new Location(-4, 2), Cardinal.WEST);
        assertEquals("(-4, 2) dirección Occidente", valid.getFormattedReport());
    }

    @Test
    public void givenAnInvalidDroneReportReturnValue() {
        IDroneReport invalid = new InvalidReport("invalid");
        assertEquals("Tiene rutas con caracteres invalidos!", invalid.getFormattedReport());
    }
}