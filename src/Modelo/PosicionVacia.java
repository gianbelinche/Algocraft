package Modelo;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


public class PosicionVacia implements Posicionable,Almacenable{


    Image sprite;

    public PosicionVacia(){
        sprite = new Image("file:src/Vista/Imagenes/CasillaVacia.png");
    }

    @Override
    public int estaLibre(){
        return 1;
    }

    @Override
    public void establecerPosicion(Posicion nuevaPosicion){ };

    public boolean esIgual(Posicionable otraPosicion){
        return otraPosicion instanceof PosicionVacia;
    }

    @Override
    public void dibujar(int x, int y, GraphicsContext gc){
        gc.drawImage(sprite,x,y);
    }

    public boolean almacenar(Almacenable objeto){ return true;}

    public Almacenable obtener(){return null;}
}
