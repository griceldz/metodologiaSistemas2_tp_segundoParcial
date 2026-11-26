
package combate;

public class Mago extends Personaje {

    @Override
    protected void prepararEquipoOHabilidad() {

        System.out.println("El mago selecciona un hechizo.");

        System.out.println("El mago prepara su bastón.");
    }

    @Override
    protected void prepararEjecucion() {

        System.out.println("El mago concentra energía mágica.");
    }

    @Override
    protected void ejecutarAtaque() {

        System.out.println("El mago ejecuta un ataque mágico.");
    }

    @Override
    protected void evaluarResultado() {

        System.out.println("El mago evalúa el resultado del combate.");
    }
}



