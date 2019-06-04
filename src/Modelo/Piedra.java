package Modelo;

public class Piedra extends Material {

    public Piedra() {
        durabilidad = 100;
    }

    public Material recoger(Material material, int desgaste){
        return material.recoger(this, desgaste);
    }

    public Material recoger(Piedra material, int desgaste){
        return desgastar(desgaste);
    }

    public Material recoger(Madera material, int desgaste){
        return desgastar(desgaste);
    }
}