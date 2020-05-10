package co.s4n.corrientazos.domain.drone;

import co.s4n.corrientazos.domain.report.IDroneReport;
import co.s4n.corrientazos.domain.route.DeliveryRoute;

public interface IDrone {

    void turnLeft();

    void turnRight();

    void continueAHead();

    IDroneReport getReport(DeliveryRoute deliveryRoute);
}
