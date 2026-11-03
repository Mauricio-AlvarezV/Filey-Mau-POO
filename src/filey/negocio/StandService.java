package filey.negocio;

import filey.datos.EstadoStand;
import filey.datos.Stand;
import filey.datos.StandRepository;
import java.util.List;

public class StandService {
    private final StandRepository repositorio;

    public StandService(StandRepository repositorio) {
        this.repositorio = repositorio;
    }

    public void registrarStand(int id, double ancho, double largo, double precioPorMetroCuadrado) {
        if (repositorio.buscarPorId(id).isPresent()) {
            throw new IllegalArgumentException("Ya existe un stand con ese identificador.");
        }
        repositorio.guardar(new Stand(id, ancho, largo, precioPorMetroCuadrado));
    }

    public List<Stand> listarStands() {
        return repositorio.listarTodos();
    }

    public Stand consultarStand(int id) {
        return repositorio.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe el stand indicado."));
    }

    public void cambiarEstado(int id, EstadoStand nuevoEstado) {
        Stand stand = consultarStand(id);
        if (stand.getEstado() == EstadoStand.VENDIDO) {
            throw new IllegalStateException("Un stand vendido no puede cambiar de estado.");
        }
        stand.setEstado(nuevoEstado);
    }

    public void eliminarStand(int id) {
        Stand stand = consultarStand(id);
        if (stand.getEstado() != EstadoStand.DISPONIBLE) {
            throw new IllegalStateException("Solo se pueden eliminar stands disponibles.");
        }
        repositorio.eliminar(id);
    }
}
