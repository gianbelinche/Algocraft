package Modelo.Jugador_;

public class Derecha implements Direccion {

    @Override
    public int getIncrementoX() {
        return 1;
    }

    @Override
    public int getIncrementoY() {
        return 0;
    }

}
