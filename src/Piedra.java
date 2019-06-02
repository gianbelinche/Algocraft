public class Piedra implements Material {

    int durabilidad;

    public Piedra() {
        durabilidad = 100;
    }

    public int durabilidad(){
        return durabilidad;
    }

    public Material recoger(Material material, int desgaste){
        return material.recoger(this, desgaste);
    }

    public Material recoger(Piedra   material, int desgaste){
        durabilidad -= desgaste;
        if(durabilidad > 0) return null;
        return this; //Debe eliminarse del mapa
    }

    public Material recoger(Madera   material, int desgaste){
        return null;
    }
}