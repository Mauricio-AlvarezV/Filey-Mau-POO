package filey.datos;

public class Stand {
    private final int identificador;
    private final double ancho;
    private final double largo;
    private final double precioPorMetroCuadrado;
    private EstadoStand estado;

    public Stand(int identificador, double ancho, double largo, double precioPorMetroCuadrado) {
        if (identificador <= 0 || ancho <= 0 || largo <= 0 || precioPorMetroCuadrado <= 0) {
            throw new IllegalArgumentException("Los datos del stand deben ser positivos.");
        }
        this.identificador = identificador;
        this.ancho = ancho;
        this.largo = largo;
        this.precioPorMetroCuadrado = precioPorMetroCuadrado;
        this.estado = EstadoStand.DISPONIBLE;
    }

    public int getIdentificador() { return identificador; }
    public double getAncho() { return ancho; }
    public double getLargo() { return largo; }
    public double getPrecioPorMetroCuadrado() { return precioPorMetroCuadrado; }
    public EstadoStand getEstado() { return estado; }
    public double calcularArea() { return ancho * largo; }
    public double calcularPrecio() { return calcularArea() * precioPorMetroCuadrado; }
    public void setEstado(EstadoStand estado) {
        if (estado == null) throw new IllegalArgumentException("El estado no puede ser nulo.");
        this.estado = estado;
    }

    @Override
    public String toString() {
        return String.format("Stand #%d | %.2f m x %.2f m | %.2f m2 | $%.2f/m2 | Total: $%.2f | %s",
                identificador, ancho, largo, calcularArea(), precioPorMetroCuadrado, calcularPrecio(), estado);
    }
}
