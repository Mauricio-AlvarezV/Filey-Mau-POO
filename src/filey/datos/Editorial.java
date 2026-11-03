package filey.datos;

public class Editorial {
    private final int identificador;
    private final String nombre;
    private final String correo;

    public Editorial(int identificador, String nombre, String correo) {
        if (identificador <= 0 || nombre == null || nombre.isBlank() || correo == null || correo.isBlank()) {
            throw new IllegalArgumentException("Datos de editorial no validos.");
        }
        this.identificador = identificador;
        this.nombre = nombre;
        this.correo = correo;
    }

    public int getIdentificador() { return identificador; }
    public String getNombre() { return nombre; }
    public String getCorreo() { return correo; }

    @Override
    public String toString() {
        return "Editorial #" + identificador + " | " + nombre + " | " + correo;
    }
}
