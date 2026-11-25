package punto5.gestor;

import punto5.modelo.Guerrero;
import punto5.modelo.Personaje;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/** Clase del subsistema: determina el mejor guerrero según su fuerza total. */
public class RankingGuerreros {

    public Optional<Guerrero> mejorGuerrero(List<Personaje> personajes) {
        return personajes.stream()
                .filter(p -> p instanceof Guerrero)
                .map(p -> (Guerrero) p)
                .max(Comparator.comparingDouble(Guerrero::getFuerzaTotal));
    }
}
