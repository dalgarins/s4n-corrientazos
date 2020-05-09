package co.s4n.corrientazos.domain.usecase.route;

import co.s4n.corrientazos.domain.report.IDroneReport;
import co.s4n.corrientazos.domain.repository.IOutputRepository;
import co.s4n.corrientazos.domain.usecase.UseCase;

import java.util.List;

public class WriteReportByDroneUseCase extends UseCase<WriteReportByDroneUseCase.Request, WriteReportByDroneUseCase.Response> {

    private IOutputRepository repository;

    public WriteReportByDroneUseCase(IOutputRepository repository) {
        this.repository = repository;
    }

    @Override
    public Response execute(Request input) {
        this.repository.saveDroneReports(input.droneReports);
        return new Response();
    }

    public static class Request implements UseCase.InputValues {
        private List<IDroneReport> droneReports;

        public Request(List<IDroneReport> droneReports) {
            this.droneReports = droneReports;
        }

        public List<IDroneReport> getDroneReports() {
            return droneReports;
        }
    }

    public static class Response implements UseCase.OutputValues {

    }

}
