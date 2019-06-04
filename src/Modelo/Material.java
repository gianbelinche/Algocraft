package Modelo;

public class Material {

    int durabilidad;

    public int durabilidad(){
        return durabilidad;
    }

    public Material desgastar(int desgaste){
        durabilidad -= desgaste;
        return this;
    }

    public Material recoger(Material material, int desgaste){
        return material._recoger(this, desgaste);
    }

    public Material _recoger(Material material, int desgaste){
        return desgastar(desgaste);
    }
}
