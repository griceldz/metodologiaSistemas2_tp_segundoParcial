package monitoreo;

public class SensorLuminosidad extends Sensor {
    private double luminosidad;

    public SensorLuminosidad(String ubicacion) {
        super(ubicacion);
    }

    public void setLuminosidad(double luminosidad) {
        this.luminosidad = luminosidad;
        notificarObservadores();
    }

    @Override
    public String getTipoVariable() {
        return "Luminosidad";
    }

    @Override
    public double getValorActual() {
        return luminosidad;
    }

    @Override
    public String getUnidad() {
        return "lux";
    }
}