package monitoreo;

public class PanelPrincipal implements Observador {
    @Override
    public void actualizar(Sensor sensor) {
        System.out.println("[PANEL PRINCIPAL] Ubicación: " + sensor.getUbicacion()
                + " | " + sensor.getTipoVariable() + ": "
                + sensor.getValorActual() + " " + sensor.getUnidad());
    }
}