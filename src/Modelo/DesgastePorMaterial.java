package Modelo;

public class DesgastePorMaterial extends Desgaste {
    private double factor;

    public DesgastePorMaterial(double nuevoFactor){
        factor = nuevoFactor;
    }


    public double desgastar(int durabilidad, int fuerza, Material material){
        if (material.obtener() instanceof Diamante){
            return durabilidad - durabilidad * factor;
        } else { return durabilidad;}
    }
}
