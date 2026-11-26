package monitoreo;

public class SensorTemperatura extends Sensor {
    private double temperatura;

    public SensorTemperatura(String ubicacion) {
        super(ubicacion);
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
        notificarObservadores();
    }

    @Override
    public String getTipoVariable() {
        return "Temperatura";
    }

    @Override
    public double getValorActual() {
        return temperatura;
    }

    @Override
    public String getUnidad() {
        return "°C";
    }
}