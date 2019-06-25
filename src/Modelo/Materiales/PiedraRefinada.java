package Modelo.Materiales;

import Modelo.Escenario.Posicionable;

public class PiedraRefinada extends Material {

    public PiedraRefinada(){
        durabilidad = 75;
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

    @Override
    public boolean esIgual(Material material){return material instanceof PiedraRefinada;}

    @Override
    public boolean esIgual(Posicionable material){return material instanceof PiedraRefinada;}
}
