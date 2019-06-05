package Modelo;

public class DesgasteLineal extends Desgaste {
    double modificador;

    public DesgasteLineal(double nuevoModificador){

        modificador = nuevoModificador;
    }

    @Override
    public double desgastar(int durabilidad, int fuerza, Material material){
        return durabilidad - fuerza * modificador;
    }
}
