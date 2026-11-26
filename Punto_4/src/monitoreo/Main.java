package monitoreo;

public class Main {
    public static void main(String[] args) {
        // 1. Creación de sensores independientes
        SensorTemperatura sensorTemp = new SensorTemperatura("Sala de Servidores");
        SensorCO2 sensorCO2 = new SensorCO2("Oficina Central");
        SensorHumedad sensorHum = new SensorHumedad("Depósito");
        SensorLuminosidad sensorLum = new SensorLuminosidad("Hall Principal");

        // 2. Creación de paneles visuales (Observadores)
        PanelPrincipal panelPrincipal = new PanelPrincipal();
        PanelAlertas panelAlertas = new PanelAlertas(30.0, 75.0, 1000.0, 800.0);
        RegistroConsola registroConsola = new RegistroConsola();

        // 3. Suscripción de paneles a los sensores
        sensorTemp.agregarObservador(panelPrincipal);
        sensorTemp.agregarObservador(panelAlertas);
        sensorTemp.agregarObservador(registroConsola);

        sensorCO2.agregarObservador(panelPrincipal);
        sensorCO2.agregarObservador(panelAlertas);

        sensorHum.agregarObservador(panelPrincipal);
        sensorLum.agregarObservador(registroConsola);

        System.out.println("=== LECTURAS INICIALES ===");
        sensorTemp.setTemperatura(24.5);
        sensorCO2.setNivelCO2(1150.0); // Supera umbral de 1000 ppm -> Dispara alerta
        sensorHum.setHumedad(60.0);
        sensorLum.setLuminosidad(450.0);

        System.out.println("\n=== DESACTIVANDO REGISTRO DE CONSOLA EN TEMPERATURA ===");
        // Demostración de activación/desactivación en tiempo real
        sensorTemp.eliminarObservador(registroConsola);

        System.out.println("\n=== NUEVA LECTURA CRÍTICA DE TEMPERATURA ===");
        sensorTemp.setTemperatura(34.0); // Supera umbral de 30 °C -> Solo actualizan Principal y Alertas
    }
}