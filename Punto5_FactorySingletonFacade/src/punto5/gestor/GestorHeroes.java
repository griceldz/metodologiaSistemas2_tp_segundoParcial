package punto5.gestor;

import punto5.fabrica.DatosPersonaje;
import punto5.fabrica.GuerreroFactory;
import punto5.fabrica.MagoFactory;
import punto5.fabrica.PersonajeFactory;
import punto5.modelo.Guerrero;
import punto5.modelo.Personaje;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * <<Singleton>> + <<Facade>>
 * Gestor central único compartido por todos los gremios. Ofrece una interfaz
 * simple y delega en las fábricas, el registro, el ranking y el generador de reportes.
 */
public final class GestorHeroes {

    private static volatile GestorHeroes instancia;

    private final Map<String, PersonajeFactory> fabricas = new HashMap<>();
    private final RegistroHeroes registro = new RegistroHeroes();
    private final RankingGuerreros ranking = new RankingGuerreros();
    private final GeneradorReporteBatalla generadorReporte = new GeneradorReporteBatalla();

    /** Constructor privado: nadie fuera de la clase puede crear otro gestor. */
    private GestorHeroes() {
        registrarFabrica("GUERRERO", new GuerreroFactory());
        registrarFabrica("MAGO", new MagoFactory());
    }

    /** Punto de acceso global a la única instancia (inicialización perezosa y segura entre hilos). */
    public static GestorHeroes getInstancia() {
        if (instancia == null) {
            synchronized (GestorHeroes.class) {
                if (instancia == null) {
                    instancia = new GestorHeroes();
                }
            }
        }
        return instancia;
    }

    /** Punto de extensión: un nuevo tipo de héroe sólo requiere registrar su fábrica. */
    public void registrarFabrica(String tipo, PersonajeFactory fabrica) {
        fabricas.put(tipo.toUpperCase(), fabrica);
    }

    // ---------- Operaciones de la fachada ----------

    public Personaje reclutarGuerrero(String gremio, String nombre, String apodo, LocalDate fecha,
                                      double poderAtaque, int victorias, double bonoPorVictoria) {
        DatosPersonaje datos = new DatosPersonaje(nombre, apodo, fecha)
                .con(GuerreroFactory.PODER_ATAQUE, poderAtaque)
                .con(GuerreroFactory.VICTORIAS, victorias)
                .con(GuerreroFactory.BONO_POR_VICTORIA, bonoPorVictoria);
        return reclutar(gremio, "GUERRERO", datos);
    }

    public Personaje reclutarMago(String gremio, String nombre, String apodo, LocalDate fecha,
                                  double reservaMana) {
        DatosPersonaje datos = new DatosPersonaje(nombre, apodo, fecha)
                .con(MagoFactory.RESERVA_MANA, reservaMana);
        return reclutar(gremio, "MAGO", datos);
    }

    /** Reclutamiento genérico: sirve para cualquier tipo de héroe que se agregue en el futuro. */
    public Personaje reclutar(String gremio, String tipo, DatosPersonaje datos) {
        PersonajeFactory fabrica = fabricas.get(tipo.toUpperCase());
        if (fabrica == null) {
            throw new IllegalArgumentException("Tipo de héroe no soportado: " + tipo);
        }
        Personaje heroe = fabrica.crear(datos);
        registro.registrar(gremio, heroe);
        return heroe;
    }

    public Optional<Guerrero> consultarMejorGuerrero() {
        return ranking.mejorGuerrero(registro.obtenerTodos());
    }

    public List<Personaje> listarHeroes(String gremio) {
        return registro.obtenerPorGremio(gremio);
    }

    public String generarReporteBatalla(String batalla, String... gremios) {
        Map<String, List<Personaje>> participantes = new LinkedHashMap<>();
        for (String g : gremios) {
            participantes.put(g, registro.obtenerPorGremio(g));
        }
        return generadorReporte.generar(batalla, participantes);
    }
}
