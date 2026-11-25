package punto5.fabrica;

import punto5.modelo.Guerrero;
import punto5.modelo.Personaje;

/** Creador concreto. */
public class GuerreroFactory extends PersonajeFactory {

    public static final String PODER_ATAQUE = "poderAtaque";
    public static final String VICTORIAS = "victorias";
    public static final String BONO_POR_VICTORIA = "bonoPorVictoria";

    @Override
    protected Personaje crearPersonaje(DatosPersonaje d) {
        return new Guerrero(d.getNombre(), d.getApodo(), d.getFechaCreacion(),
                d.getAtributo(PODER_ATAQUE),
                (int) d.getAtributo(VICTORIAS),
                d.getAtributo(BONO_POR_VICTORIA));
    }
}
