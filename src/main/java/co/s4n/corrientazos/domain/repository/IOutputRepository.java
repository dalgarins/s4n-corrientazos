package co.s4n.corrientazos.domain.repository;

import co.s4n.corrientazos.domain.report.IDroneReport;

import java.util.List;

public interface IOutputRepository {

    void saveDroneReports(List<IDroneReport> reports);

}
