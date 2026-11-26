
package combate;

public class Main {

    public static void main(String[] args) {

        // Creación de los personajes.
        Personaje guerrero = new Guerrero();

        Personaje mago = new Mago();

        Personaje arquero = new Arquero();

        // Combate del Guerrero.
        System.out.println("===== COMBATE DEL GUERRERO =====");

        guerrero.combatir();

        System.out.println();

        // Combate del Mago.
        System.out.println("===== COMBATE DEL MAGO =====");

        mago.combatir();

        System.out.println();

        // Combate del Arquero.
        System.out.println("===== COMBATE DEL ARQUERO =====");

        arquero.combatir();
    }
}

