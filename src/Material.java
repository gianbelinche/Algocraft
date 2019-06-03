abstract class Material {

    int durabilidad;

    public int durabilidad(){
        return durabilidad;
    }

    public Material desgastar(int desgaste){
        durabilidad -= desgaste;
        return this;
    }


    abstract Material recoger(Material material, int desgaste);

    abstract Material recoger(Piedra   material, int desgaste);

    abstract Material recoger(Madera   material, int desgaste);
}