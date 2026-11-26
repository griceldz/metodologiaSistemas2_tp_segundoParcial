package monitoreo;

public class SensorHumedad extends Sensor {
    private double humedad;

    public SensorHumedad(String ubicacion) {
        super(ubicacion);
    }

    public void setHumedad(double humedad) {
        this.humedad = humedad;
        notificarObservadores();
    }

    @Override
    public String getTipoVariable() {
        return "Humedad";
    }

    @Override
    public double getValorActual() {
        return humedad;
    }

    @Override
    public String getUnidad() {
        return "%";
    }
}