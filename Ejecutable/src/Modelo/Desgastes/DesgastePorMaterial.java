package Modelo.Desgastes;

import Modelo.Excepciones.HerramientaRotaException;
import Modelo.Materiales.Diamante;
import Modelo.Materiales.Material;


public class DesgastePorMaterial implements Desgaste {
    private double factor;

    public DesgastePorMaterial(double nuevoFactor){
        factor = nuevoFactor;
    }


    @Override
    public double desgastar(int durabilidad, int fuerza, Material material){
        return durabilidad;
    }

    @Override
    public double desgastar(int durabilidad, int fuerza, Diamante material){
        if (durabilidad == 0){
            throw new HerramientaRotaException();
        }
        return durabilidad - durabilidad * factor;
    }
}
