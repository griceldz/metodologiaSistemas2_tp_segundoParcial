package punto5.fabrica;

import punto5.modelo.Personaje;

/**
 * Creador abstracto del patrón Factory Method.
 * crear() valida los datos comunes y delega en el método fábrica crearPersonaje().
 */
public abstract class PersonajeFactory {

    public final Personaje crear(DatosPersonaje datos) {
        if (datos.getNombre() == null || datos.getNombre().isBlank()) {
            throw new IllegalArgumentException("El nombre es obligatorio");
        }
        if (datos.getFechaCreacion() == null) {
            throw new IllegalArgumentException("La fecha de creación es obligatoria");
        }
        return crearPersonaje(datos);
    }

    /** Método fábrica: cada creador concreto decide qué personaje instanciar. */
    protected abstract Personaje crearPersonaje(DatosPersonaje datos);
}
