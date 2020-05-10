package co.s4n.corrientazos;

import co.s4n.corrientazos.app.controller.IDeliveryController;
import co.s4n.corrientazos.app.injection.Injection;
import co.s4n.corrientazos.data.repository.RoutesRepository;

public class CorrientazosApplication {

    public static void main(String[] args) {

        RoutesRepository repository = Injection.provideRoutesRepository("input/",
                Injection.provideWriteReport("output/"));

        IDeliveryController controller = Injection.provideDeliveryController(
            Injection.provideUseCaseExecutor(),
            Injection.provideGetAllRoutesUseCase(repository),
            Injection.provideDroneProcessRouteUseCase(),
            Injection.provideWriteReportByDroneUseCase(repository),
            Injection.provideDroneFactory()
        );

        controller.startDelivery();

    }
}
