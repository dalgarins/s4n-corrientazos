package co.s4n.corrientazos.data.report;

import co.s4n.corrientazos.domain.location.Location;
import co.s4n.corrientazos.domain.orientation.Cardinal;
import co.s4n.corrientazos.domain.report.DroneReport;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class WriteDroneReportTest {

    @Test
    public void writeReport() {

        DroneReport droneReport = new DroneReport(new Location(0, 0), Cardinal.NORTH);

        WriteDroneReport writeDroneReport = new WriteDroneReport("output_test/");
        writeDroneReport.writeReport("out01.txt", Arrays.asList(droneReport));
    }
}