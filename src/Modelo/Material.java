package Modelo;

abstract class Material implements Posicionable{

    Posicion posicion;
    int durabilidad;

    public int durabilidad(){
        return durabilidad;
    }

    protected Material desgastar(int desgaste){
        durabilidad -= desgaste;
        if(durabilidad > 0) return null;
        return this;
    }

    abstract Material recoger(Material material, int desgaste);

    abstract Material recoger(Madera material, int desgaste);

    abstract Material recoger(Piedra material, int desgaste);

    abstract Material recoger(Metal material, int desgaste);

    abstract Material recoger(PiedraRefinada material, int desgaste);

    abstract Material recoger(Diamante material, int desgaste);

    abstract boolean esIgual(Material material);

    @Override
    public int estaLibre() {
        return 0;
    }

    @Override
    public void establecerPosicion(Posicion nuevaPosicion){
        posicion = nuevaPosicion;
    }
}
