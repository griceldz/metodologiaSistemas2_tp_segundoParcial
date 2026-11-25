package punto5.modelo;

import java.time.LocalDate;
import java.time.Period;

/** Producto concreto. */
public class Mago extends Personaje {

    private final double reservaMana;

    public Mago(String nombre, String apodo, LocalDate fechaCreacion, double reservaMana) {
        super(nombre, apodo, fechaCreacion);
        this.reservaMana = reservaMana;
    }

    public int getAntiguedad() {
        return Period.between(getFechaCreacion(), LocalDate.now()).getYears();
    }

    /** Menos de 3 años: sin bono; de 3 a 6: +4 %; más de 6: +12 %. */
    public double getReservaManaFinal() {
        int anios = getAntiguedad();
        if (anios < 3) return reservaMana;
        if (anios <= 6) return reservaMana * 1.04;
        return reservaMana * 1.12;
    }

    @Override
    public double getValorCombate() { return getReservaManaFinal(); }

    @Override
    public String getTipo() { return "Mago"; }

    public double getReservaMana() { return reservaMana; }
}
