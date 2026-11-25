package punto5.gestor;

import punto5.modelo.Personaje;

import java.util.List;
import java.util.Map;

/** Clase del subsistema: arma el reporte de una batalla entre gremios. */
public class GeneradorReporteBatalla {

    public String generar(String batalla, Map<String, List<Personaje>> participantes) {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Reporte de batalla: ").append(batalla).append(" ===\n");
        String ganador = null;
        double mayorPoder = -1;

        for (Map.Entry<String, List<Personaje>> e : participantes.entrySet()) {
            double poderGremio = 0;
            sb.append("Gremio ").append(e.getKey()).append(":\n");
            for (Personaje p : e.getValue()) {
                sb.append(String.format("  - %s \"%s\" [%s] valor de combate: %.2f%n",
                        p.getNombre(), p.getApodo(), p.getTipo(), p.getValorCombate()));
                poderGremio += p.getValorCombate();
            }
            sb.append(String.format("  Poder total del gremio: %.2f%n", poderGremio));
            if (poderGremio > mayorPoder) {
                mayorPoder = poderGremio;
                ganador = e.getKey();
            }
        }
        sb.append("Resultado: gana el gremio ").append(ganador).append("\n");
        return sb.toString();
    }
}
