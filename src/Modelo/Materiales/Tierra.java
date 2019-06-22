package Modelo.Materiales;
import Modelo.Escenario.Posicionable;

public class Tierra extends Material {
    @Override
    public Material recoger(Material material, int desgaste){
        return null;
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
        return null;
    }

    @Override
    public Material serRecogido(Diamante material, int desgaste){
        return null;
    }

    @Override
    public boolean esIgual(Material material){
        return material instanceof Tierra;
    }

    @Override
    public boolean esIgual(Posicionable material){
        return material instanceof Tierra;
    }
}
