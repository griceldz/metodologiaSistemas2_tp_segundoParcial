package punto5.modelo;

import java.time.LocalDate;

/**
 * Producto abstracto del patrón Factory Method.
 * Contiene los datos personales comunes a todo héroe.
 */
public abstract class Personaje {

    private static int secuenciaId = 0;

    private final int id;
    private final String nombre;
    private final String apodo;
    private final LocalDate fechaCreacion;

    protected Personaje(String nombre, String apodo, LocalDate fechaCreacion) {
        this.id = ++secuenciaId;
        this.nombre = nombre;
        this.apodo = apodo;
        this.fechaCreacion = fechaCreacion;
    }

    /** Fuerza total (guerrero) o reserva de maná final (mago). */
    public abstract double getValorCombate();

    public abstract String getTipo();

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getApodo() { return apodo; }
    public LocalDate getFechaCreacion() { return fechaCreacion; }

    @Override
    public String toString() {
        return String.format("#%d %s \"%s\" (%s) - valor de combate: %.2f",
                id, nombre, apodo, getTipo(), getValorCombate());
    }
}
