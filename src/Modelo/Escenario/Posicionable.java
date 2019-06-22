package Modelo.Escenario;

public interface Posicionable {

    public Posicion actualizarPosicion(int viejaX, int viejaY,int viejaZ, int nuevaX, int nuevaY,int nuevaZ);

    void establecerPosicion(Posicion nuevaPosicion);

    boolean esIgual(Posicionable otroPosicionable);
}
