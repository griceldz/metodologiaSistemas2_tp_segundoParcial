package combate;

public abstract class Personaje{

    //Template Method: define el esqueleto de un algoritmo.
    //final impide que las subclases modifiquen su estructura.
    public final void combatir() {
        prepararEquipoOHabilidad();

        prepararEjecucion();

        ejecutarAtaque();

        evaluarResultado();
    }

    //Pasos abstractos que cada personaje debe implementar.

    protected abstract void prepararEquipoOHabilidad();

    protected abstract void prepararEjecucion();

    protected abstract void ejecutarAtaque();

    

    //Hook: comportammiento predeterminado que puede redefinirse

    protected void evaluarResultado() {
        System.out.println("Se evalúa el resultado general del combate.");
    }


}