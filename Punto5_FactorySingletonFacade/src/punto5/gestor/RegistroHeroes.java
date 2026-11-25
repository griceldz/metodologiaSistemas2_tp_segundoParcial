package punto5.gestor;

import punto5.modelo.Personaje;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/** Clase del subsistema: almacena los héroes reclutados por cada gremio. */
public class RegistroHeroes {

    private final Map<String, List<Personaje>> heroesPorGremio = new LinkedHashMap<>();

    public void registrar(String gremio, Personaje personaje) {
        heroesPorGremio.computeIfAbsent(gremio, g -> new ArrayList<>()).add(personaje);
    }

    public List<Personaje> obtenerPorGremio(String gremio) {
        return Collections.unmodifiableList(heroesPorGremio.getOrDefault(gremio, List.of()));
    }

    public List<Personaje> obtenerTodos() {
        List<Personaje> todos = new ArrayList<>();
        heroesPorGremio.values().forEach(todos::addAll);
        return todos;
    }
}
