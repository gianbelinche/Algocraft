package Modelo;

public class Piedra extends Material {

    public Piedra() {
        durabilidad = 30;
    }

    @Override
    public Material recoger(Material material, int desgaste){
        return material.recoger(this, desgaste);
    }

    @Override
    public Material recoger(Madera material, int desgaste){
        return desgastar(desgaste);
    }

    @Override
    public Material recoger(Piedra material, int desgaste){
        return desgastar(desgaste);
    }

    @Override
    public Material recoger(Metal material, int desgaste){
        return desgastar(desgaste);
    }

    @Override
    public Material recoger(PiedraRefinada material, int desgaste){
        return desgastar(desgaste);
    }

    @Override
    public Material recoger(Diamante material, int desgaste){
        return desgastar(desgaste);
    }

}