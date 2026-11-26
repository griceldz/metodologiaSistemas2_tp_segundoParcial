package monitoreo;

public class SensorCO2 extends Sensor {
    private double nivelCO2;

    public SensorCO2(String ubicacion) {
        super(ubicacion);
    }

    public void setNivelCO2(double nivelCO2) {
        this.nivelCO2 = nivelCO2;
        notificarObservadores();
    }

    @Override
    public String getTipoVariable() {
        return "Nivel de CO2";
    }

    @Override
    public double getValorActual() {
        return nivelCO2;
    }

    @Override
    public String getUnidad() {
        return "ppm";
    }
}