package Modelo.Escenario;

import Modelo.Almacenable;

public class PosicionVacia implements Posicionable, Almacenable {

    @Override
    public Posicion actualizarPosicion(int viejaX, int viejaY, int nuevaX, int nuevaY){
        return new Posicion(nuevaX,nuevaY);
    }

    @Override
    public void establecerPosicion(Posicion nuevaPosicion){ }

    public boolean esIgual(Posicionable otraPosicion){
        return otraPosicion instanceof PosicionVacia;
    }

    public boolean almacenar(Almacenable objeto){ return true;}

    public Almacenable obtener(){return null;}
}
