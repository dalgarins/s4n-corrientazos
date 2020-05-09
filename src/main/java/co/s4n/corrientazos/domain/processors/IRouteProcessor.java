package co.s4n.corrientazos.domain.processors;

import co.s4n.corrientazos.domain.drone.IDrone;
import co.s4n.corrientazos.domain.report.IDroneReport;
import co.s4n.corrientazos.domain.route.IDroneRoute;

import java.util.List;

public interface IRouteProcessor {

    List<IDroneReport> process(IDrone drone, IDroneRoute routes);

}
