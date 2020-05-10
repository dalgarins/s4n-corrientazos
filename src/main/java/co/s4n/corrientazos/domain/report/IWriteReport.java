package co.s4n.corrientazos.domain.report;

import java.util.List;

public interface IWriteReport {

    void writeReport(String path, List<IDroneReport> reportList);
}
