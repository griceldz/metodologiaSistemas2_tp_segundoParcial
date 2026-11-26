package monitoreo;

public class PanelAlertas implements Observador {
    private double umbralTemperatura;
    private double umbralHumedad;
    private double umbralCO2;
    private double umbralLuminosidad;

    public PanelAlertas(double uTemp, double uHum, double uCO2, double uLum) {
        this.umbralTemperatura = uTemp;
        this.umbralHumedad = uHum;
        this.umbralCO2 = uCO2;
        this.umbralLuminosidad = uLum;
    }

    @Override
    public void actualizar(Sensor sensor) {
        double valor = sensor.getValorActual();
        boolean superaUmbral = false;

        switch (sensor.getTipoVariable()) {
            case "Temperatura":
                superaUmbral = valor > umbralTemperatura;
                break;
            case "Humedad":
                superaUmbral = valor > umbralHumedad;
                break;
            case "Nivel de CO2":
                superaUmbral = valor > umbralCO2;
                break;
            case "Luminosidad":
                superaUmbral = valor > umbralLuminosidad;
                break;
        }

        if (superaUmbral) {
            System.out.println("¡[ALERTA]! " + sensor.getTipoVariable()
                    + " crítico en " + sensor.getUbicacion()
                    + ": " + valor + " " + sensor.getUnidad());
        }
    }
}