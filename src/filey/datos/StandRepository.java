package filey.datos;

import java.util.List;
import java.util.Optional;

public interface StandRepository {
    void guardar(Stand stand);
    Optional<Stand> buscarPorId(int identificador);
    List<Stand> listarTodos();
    boolean eliminar(int identificador);
}
