package punto5.fabrica;

import punto5.modelo.Mago;
import punto5.modelo.Personaje;

/** Creador concreto. */
public class MagoFactory extends PersonajeFactory {

    public static final String RESERVA_MANA = "reservaMana";

    @Override
    protected Personaje crearPersonaje(DatosPersonaje d) {
        return new Mago(d.getNombre(), d.getApodo(), d.getFechaCreacion(),
                d.getAtributo(RESERVA_MANA));
    }
}
