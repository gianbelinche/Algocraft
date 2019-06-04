package Modelo;

public class DesgasteLineal extends Desgaste {
    double modificador;

    public DesgasteLineal(double nuevoModificador){

        modificador = nuevoModificador;
    }

    @Override
    public double desgastar(int durabilidad, int fuerza){
        return durabilidad - fuerza * modificador;
    }
}
