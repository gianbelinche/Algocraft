package Modelo;

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
        return durabilidad - durabilidad * factor;
    }
}
