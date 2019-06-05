package Modelo;

abstract class Material {

    int durabilidad;

    public int durabilidad(){
        return durabilidad;
    }

    protected Material desgastar(int desgaste){
        durabilidad -= desgaste;
        if(durabilidad > 0) return null;
        //Elminar material del mapa.
        return this;
    }

    abstract Material recoger(Material material, int desgaste);

    abstract Material recoger(Madera material, int desgaste);

    abstract Material recoger(Piedra material, int desgaste);

    abstract Material recoger(Metal material, int desgaste);

    abstract Material recoger(PiedraRefinada material, int desgaste);

    abstract Material recoger(Diamante material, int desgaste);
}
