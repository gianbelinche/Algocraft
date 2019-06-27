package Modelo.Escenario;

import Vista.Ventana;

public class Bote extends PosicionVacia {

    private  Ventana ventana;

    public Bote(Ventana nuevaVentana){
        ventana = nuevaVentana;
    }

    @Override
    public Posicion actualizarPosicion(int viejaX, int viejaY,int viejaZ, int nuevaX, int nuevaY,int nuevaZ){
        ventana.mostrarVictoria();
        return new Posicion(nuevaX,nuevaY,nuevaZ);
    }
}
