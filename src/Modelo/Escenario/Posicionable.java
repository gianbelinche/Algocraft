package Modelo.Escenario;

public interface Posicionable {

    int estaLibre();

    void establecerPosicion(Posicion nuevaPosicion);

    boolean esIgual(Posicionable otroPosicionable);

    String obtenerRutaImagen();
}
