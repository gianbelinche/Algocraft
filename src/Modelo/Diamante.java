package Modelo;

import Vista.Vista;
import javafx.scene.image.Image;

public class Diamante extends Material {

    public Diamante(){
        vista = new Vista("file:src/Vista/Imagenes/CasillaDiamante.png");
        durabilidad = 100;
    }

    @Override
    public Material recoger(Material material, int desgaste){
        return material.serRecogido(this, desgaste);
    }

    @Override
    public Material serRecogido(Madera material, int desgaste){
        return null;
    }

    @Override
    public Material serRecogido(Piedra material, int desgaste){
        return null;
    }

    @Override
    public Material serRecogido(Metal material, int desgaste){
        return null;
    }

    @Override
    public Material serRecogido(PiedraRefinada material, int desgaste){
        return desgastar(desgaste);
    }

    @Override
    public Material serRecogido(Diamante material, int desgaste){
        return desgastar(desgaste);
    }

    public boolean esIgual(Material material){
        return material instanceof Diamante;
    }

    public boolean esIgual(Posicionable material){
        return material instanceof Diamante;
    }


}
