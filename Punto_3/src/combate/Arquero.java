
package combate;

public class Arquero extends Personaje {

    @Override
    protected void prepararEquipoOHabilidad() {

        System.out.println("El arquero prepara su arco y sus flechas.");
    }

    @Override
    protected void prepararEjecucion() {

        System.out.println("El arquero apunta al enemigo.");
    }

    @Override
    protected void ejecutarAtaque() {

        System.out.println("El arquero dispara una flecha.");
    }

    @Override
    protected void evaluarResultado() {

        System.out.println("El arquero evalúa el resultado de su disparo.");
    }
}
