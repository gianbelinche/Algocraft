package Modelo.Desgastes;

import Modelo.Materiales.Diamante;
import Modelo.Materiales.Material;

public class DesgasteLineal implements Desgaste {
    double modificador;

    public DesgasteLineal(double nuevoModificador){

        modificador = nuevoModificador;
    }

    @Override
    public double desgastar(int durabilidad, int fuerza, Material material){
        return durabilidad - fuerza * modificador;
    }

    @Override
    public double desgastar(int durabilidad, int fuerza, Diamante material){
        return durabilidad - fuerza * modificador;
    }
}
