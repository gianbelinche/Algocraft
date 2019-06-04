package Modelo;

public class Madera extends Material {

    public Madera() {
        durabilidad = 100;
    }

    public Material recoger(Material material, int desgaste){
        return material.recoger(this, desgaste);
    }

    public Material recoger(Piedra   material, int desgaste){
        return desgastar(desgaste);
    }

    public Material recoger(Madera   material, int desgaste){
        return desgastar(desgaste);
    }
}
