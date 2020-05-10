package co.s4n.corrientazos.domain.report;

public class InvalidReport implements IDroneReport {

    private String deliveryName;

    public InvalidReport(String deliveryName) {
        this.deliveryName = deliveryName;
    }

    @Override
    public String getDeliveryName() {
        return this.deliveryName;
    }

    @Override
    public String getFormattedReport() {
        return "Tiene rutas con caracteres invalidos!";
    }
}
