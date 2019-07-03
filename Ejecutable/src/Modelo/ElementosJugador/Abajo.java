package Modelo.ElementosJugador;

public class Abajo implements Direccion {

    @Override
    public int getIncrementoX() {
        return 0;
    }

    @Override
    public int getIncrementoY() {
        return 1;
    }

}
