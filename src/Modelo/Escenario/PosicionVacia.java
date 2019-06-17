package Modelo.Escenario;

import Modelo.Almacenable;
import javafx.scene.canvas.GraphicsContext;
import Vista.Vista;

public class PosicionVacia implements Posicionable, Almacenable {


    Vista vista;

    public PosicionVacia(){
       vista = new Vista("file:src/Vista/Imagenes/CasillaVacia.png");
    }

    @Override
    public int estaLibre(){
        return 1;
    }

    @Override
    public void establecerPosicion(Posicion nuevaPosicion){ }

    public boolean esIgual(Posicionable otraPosicion){
        return otraPosicion instanceof PosicionVacia;
    }

    public boolean almacenar(Almacenable objeto){ return true;}

    public void dibujar(int x, int y, GraphicsContext gc){
        vista.dibujar(x,y,gc);
    }

    public Almacenable obtener(){return null;}
}
