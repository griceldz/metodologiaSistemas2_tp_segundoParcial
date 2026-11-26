package monitoreo;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class RegistroConsola implements Observador {
    @Override
    public void actualizar(Sensor sensor) {
        String hora = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.println("[LOG CONSOLA " + hora + "] Cambio detectado -> "
                + sensor.getUbicacion() + " (" + sensor.getTipoVariable() + "): "
                + sensor.getValorActual() + " " + sensor.getUnidad());
    }
}