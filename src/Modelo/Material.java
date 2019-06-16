package Modelo;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

abstract class Material implements Posicionable,Almacenable{



    Image sprite;
    Posicion posicion;
    int durabilidad;

    public int durabilidad(){
        return durabilidad;
    }

    protected Material desgastar(int desgaste){
        durabilidad -= desgaste;
        if(durabilidad > 0) return null;
        posicion.borrar(this);
        return this;
    }

    abstract Material recoger(Material material, int desgaste);

    abstract Material serRecogido(Madera material, int desgaste);

    abstract Material serRecogido(Piedra material, int desgaste);

    abstract Material serRecogido(Metal material, int desgaste);

    abstract Material serRecogido(PiedraRefinada material, int desgaste);

    abstract Material serRecogido(Diamante material, int desgaste);

    abstract boolean esIgual(Material material);

    @Override
    public int estaLibre() {
        return 0;
    }

    @Override
    public void establecerPosicion(Posicion nuevaPosicion){
        posicion = nuevaPosicion;
    }

    public boolean almacenar(Almacenable objeto){ return false;}

    public Almacenable obtener(){return this;}

    @Override
    public void dibujar(int x, int y, GraphicsContext gc){
        gc.drawImage(sprite,x,y);
    }
}
