package Modelo.ElementosJugador;

public class Izquierda implements Direccion {

    @Override
    public int getIncrementoX() {
        return -1;
    }

    @Override
    public int getIncrementoY() {
        return 0;
    }

}
