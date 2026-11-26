public class Personaje {
    private final String nombre;
    private final double danio;
    private final TipoHabilidad tipoHabilidad;
    // constructor y getters...
    public double calcularDanioTotal() { return tipoHabilidad.calcularDanio(danio); }
    public String getInfo() {
        return nombre + " tiene como daño " + danio + "\n" + tipoHabilidad.getDescripcion();
    }
}