package combate;

public class Guerrero extends Personaje {

    @Override
    protected void prepararEquipoOHabilidad(){
        System.out.println("El guerrero prepara su arma.");

        System.out.println("El guerrero equipa su armadura.");
    }

    @Override
    protected void prepararEjecucion() {

        System.out.println("El guerrero se acerca al enemigo.");
    }

    @Override
    protected void ejecutarAtaque() {

        System.out.println("El guerrero ejecuta un ataque físico.");
    }

    @Override
    protected void evaluarResultado() {

        System.out.println("El guerrero evalúa el resultado del combate.");
    }




}