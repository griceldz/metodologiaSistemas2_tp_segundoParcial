public class Videojuego {
    private final List<Personaje> personajes = new ArrayList<>();

    public Personaje personajeConMasDanio() {
        Personaje mejor = null;
        double max = 0;
        for (Personaje p : personajes) {
            double danio = p.calcularDanioTotal();
            if (danio > max) { mejor = p; max = danio; }
        }
        return mejor;
    }

    public void imprimirInfo(Personaje p) {
        System.out.println(p.getInfo());
    }
}