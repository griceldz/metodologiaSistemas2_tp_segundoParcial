package punto5.fabrica;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * Solicitud de creación: datos personales comunes + atributos propios del tipo.
 * Permite que el código que pide la creación no dependa de los constructores concretos.
 */
public class DatosPersonaje {

    private final String nombre;
    private final String apodo;
    private final LocalDate fechaCreacion;
    private final Map<String, Double> atributos = new HashMap<>();

    public DatosPersonaje(String nombre, String apodo, LocalDate fechaCreacion) {
        this.nombre = nombre;
        this.apodo = apodo;
        this.fechaCreacion = fechaCreacion;
    }

    public DatosPersonaje con(String atributo, double valor) {
        atributos.put(atributo, valor);
        return this;
    }

    public double getAtributo(String atributo) {
        Double valor = atributos.get(atributo);
        if (valor == null) {
            throw new IllegalArgumentException("Falta el atributo obligatorio: " + atributo);
        }
        return valor;
    }

    public String getNombre() { return nombre; }
    public String getApodo() { return apodo; }
    public LocalDate getFechaCreacion() { return fechaCreacion; }
}
