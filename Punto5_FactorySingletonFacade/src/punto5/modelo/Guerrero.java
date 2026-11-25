package punto5.modelo;

import java.time.LocalDate;

/** Producto concreto. */
public class Guerrero extends Personaje {

    private final double poderAtaque;
    private int victorias;
    private final double bonoPorVictoria;

    public Guerrero(String nombre, String apodo, LocalDate fechaCreacion,
                    double poderAtaque, int victorias, double bonoPorVictoria) {
        super(nombre, apodo, fechaCreacion);
        this.poderAtaque = poderAtaque;
        this.victorias = victorias;
        this.bonoPorVictoria = bonoPorVictoria;
    }

    /** Fuerza total = victorias * bono; nunca menor que el poder de ataque base. */
    public double getFuerzaTotal() {
        return Math.max(victorias * bonoPorVictoria, poderAtaque);
    }

    public void registrarVictoria() { victorias++; }

    @Override
    public double getValorCombate() { return getFuerzaTotal(); }

    @Override
    public String getTipo() { return "Guerrero"; }

    public double getPoderAtaque() { return poderAtaque; }
    public int getVictorias() { return victorias; }
    public double getBonoPorVictoria() { return bonoPorVictoria; }
}
