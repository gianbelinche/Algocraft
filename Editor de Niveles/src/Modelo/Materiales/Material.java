package Modelo.Materiales;

import Modelo.Escenario.Posicion;
import Modelo.Escenario.Posicionable;

public abstract class Material implements Posicionable{

    Posicion posicion;

    @Override
    public void establecerPosicion(Posicion nuevaPosicion){
        posicion = nuevaPosicion;
    }

}
