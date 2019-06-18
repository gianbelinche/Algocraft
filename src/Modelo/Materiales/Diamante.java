package Modelo.Materiales;

import Modelo.Escenario.Posicionable;

public class Diamante extends Material {

    private String ruta;

    public Diamante(){
        durabilidad = 100;
        ruta = "file:src/Vista/Imagenes/CasillaDiamante.png";
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

    @Override
    public String obtenerRutaImagen(){
        return ruta;
    }

}
