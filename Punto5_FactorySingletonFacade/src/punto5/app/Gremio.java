package punto5.app;

import punto5.gestor.GestorHeroes;
import punto5.modelo.Personaje;

import java.time.LocalDate;
import java.util.List;

/** Cliente: sólo conoce a la fachada GestorHeroes, no a las fábricas ni a las clases concretas. */
public class Gremio {

    private final String nombre;
    private final GestorHeroes gestor = GestorHeroes.getInstancia();

    public Gremio(String nombre) {
        this.nombre = nombre;
    }

    public Personaje reclutarGuerrero(String nombre, String apodo, LocalDate fecha,
                                      double poderAtaque, int victorias, double bono) {
        return gestor.reclutarGuerrero(this.nombre, nombre, apodo, fecha, poderAtaque, victorias, bono);
    }

    public Personaje reclutarMago(String nombre, String apodo, LocalDate fecha, double reservaMana) {
        return gestor.reclutarMago(this.nombre, nombre, apodo, fecha, reservaMana);
    }

    public void mostrarValorCombate() {
        System.out.println("Miembros del gremio " + nombre + ":");
        List<Personaje> miembros = gestor.listarHeroes(nombre);
        for (Personaje p : miembros) {
            System.out.printf("  %s \"%s\": %.2f%n", p.getNombre(), p.getApodo(), p.getValorCombate());
        }
    }

    public GestorHeroes getGestor() { return gestor; }
    public String getNombre() { return nombre; }
}
