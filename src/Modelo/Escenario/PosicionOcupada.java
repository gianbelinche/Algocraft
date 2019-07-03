package Modelo.Escenario;

import Modelo.Inventario.Almacenable;

public class PosicionOcupada implements Posicionable, Almacenable {

    @Override
    public Posicion actualizarPosicion(int viejaX, int viejaY,int viejaZ, int nuevaX, int nuevaY,int nuevaZ){
        return new Posicion(viejaX,viejaY,viejaZ);
    }

    @Override
    public void establecerPosicion(Posicion nuevaPosicion){ }

    public boolean esIgual(Posicionable otraPosicion){
        return otraPosicion instanceof PosicionOcupada;
    }

    public boolean almacenar(Almacenable objeto){ return true;}
}
