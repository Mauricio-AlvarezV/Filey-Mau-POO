package filey.datos;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class StandRepositoryMemoria implements StandRepository {
    private final Map<Integer, Stand> stands = new LinkedHashMap<>();

    @Override
    public void guardar(Stand stand) {
        stands.put(stand.getIdentificador(), stand);
    }

    @Override
    public Optional<Stand> buscarPorId(int identificador) {
        return Optional.ofNullable(stands.get(identificador));
    }

    @Override
    public List<Stand> listarTodos() {
        return new ArrayList<>(stands.values());
    }

    @Override
    public boolean eliminar(int identificador) {
        return stands.remove(identificador) != null;
    }
}
