package punto5.app;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Gremio dragones = new Gremio("Dragones de Hierro");
        Gremio arcanos = new Gremio("Círculo Arcano");

        // Singleton: ambos gremios trabajan sobre la misma instancia del gestor
        System.out.println("¿Mismo gestor? " + (dragones.getGestor() == arcanos.getGestor()));
        System.out.println();

        // Factory Method (a través de la fachada): el gremio no hace "new Guerrero(...)"
        dragones.reclutarGuerrero("Thorgar", "El Implacable", LocalDate.of(2020, 3, 10), 500, 30, 25);
        dragones.reclutarGuerrero("Brienne", "La Muralla", LocalDate.of(2023, 7, 1), 400, 10, 20);
        dragones.reclutarMago("Eldrin", "Voz del Trueno", LocalDate.of(2024, 1, 15), 800);

        arcanos.reclutarMago("Morgana", "La Eterna", LocalDate.of(2017, 5, 20), 900);
        arcanos.reclutarMago("Alarion", "Ojo Astral", LocalDate.of(2021, 9, 2), 700);
        arcanos.reclutarGuerrero("Kael", "Filo Rojo", LocalDate.of(2022, 2, 2), 600, 15, 30);

        dragones.mostrarValorCombate();
        arcanos.mostrarValorCombate();
        System.out.println();

        // Facade: consultas y reportes sin conocer el subsistema
        dragones.getGestor().consultarMejorGuerrero()
                .ifPresent(g -> System.out.println("Mejor guerrero: " + g));
        System.out.println();
        System.out.print(arcanos.getGestor()
                .generarReporteBatalla("Batalla del Valle Gris", dragones.getNombre(), arcanos.getNombre()));
    }
}
