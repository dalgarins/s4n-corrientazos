package co.s4n.corrientazos.domain.report;

public class InvalidReport implements IDroneReport {
    @Override
    public String getFormattedReport() {
        return "Tiene rutas con caracteres invalidos!";
    }
}
