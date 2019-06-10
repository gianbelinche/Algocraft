package Modelo;

public class PosicionVacia implements Posicionable{

    @Override
    public int estaLibre(){
        return 1;
    }

    @Override
    public void establecerPosicion(Posicion nuevaPosicion){ };
}
