package co.s4n.corrientazos.domain.report;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvalidReport that = (InvalidReport) o;
        return Objects.equals(deliveryName, that.deliveryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deliveryName);
    }
}
