public class HabilidadMagica implements TipoHabilidad {
    public double calcularDanio(double danioBase) { return danioBase * 2; }
    public String getDescripcion() {
        return "Habilidad tipo habilidad mágica\nEsta habilidad dobla tu fuerza";
    }
}