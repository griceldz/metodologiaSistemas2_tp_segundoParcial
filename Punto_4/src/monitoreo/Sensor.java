package monitoreo;

import java.util.ArrayList;
import java.util.List;

public abstract class Sensor {
    private String ubicacion;
    private List<Observador> observadores;

    public Sensor(String ubicacion) {
        this.ubicacion = ubicacion;
        this.observadores = new ArrayList<>();
    }

    public void agregarObservador(Observador obs) {
        if (obs != null && !observadores.contains(obs)) {
            observadores.add(obs);
        }
    }

    public void eliminarObservador(Observador obs) {
        observadores.remove(obs);
    }

    public void notificarObservadores() {
        for (Observador obs : observadores) {
            obs.actualizar(this);
        }
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public abstract String getTipoVariable();
    public abstract double getValorActual();
    public abstract String getUnidad();
}