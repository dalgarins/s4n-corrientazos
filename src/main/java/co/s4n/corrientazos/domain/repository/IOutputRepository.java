package co.s4n.corrientazos.domain.repository;

import co.s4n.corrientazos.domain.report.DroneReport;

import java.util.List;

public interface IOutputRepository {

    void saveDroneReports(List<DroneReport> reports);

}
