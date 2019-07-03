package Modelo.Materiales;

import Modelo.Escenario.Posicionable;

public class Madera extends Material {

    public Madera() {
        durabilidad = 10;
    }

    @Override
    public Material recoger(Material material, int desgaste){
        return material.serRecogido(this, desgaste);
    }

    @Override
    public Material serRecogido(Madera material, int desgaste){
        return desgastar(desgaste);
    }

    @Override
    public Material serRecogido(Piedra material, int desgaste){
        return desgastar(desgaste);
    }

    @Override
    public Material serRecogido(Metal material, int desgaste){
        return desgastar(desgaste);
    }

    @Override
    public Material serRecogido(PiedraRefinada material, int desgaste){
        return desgastar(desgaste);
    }

    @Override
    public Material serRecogido(Diamante material, int desgaste){
        return desgastar(desgaste);
    }

    @Override
    public boolean esIgual(Material material){
        return material instanceof Madera;
    }

    @Override
    public boolean esIgual(Posicionable material){
        return material instanceof Madera;
    }

}
