package Modelo.Escenario;

public interface Posicionable {

    Posicion actualizarPosicion(int viejaX, int viejaY, int nuevaX, int nuevaY);

    void establecerPosicion(Posicion nuevaPosicion);

    boolean esIgual(Posicionable otroPosicionable);

    String obtenerRutaImagen();
}
