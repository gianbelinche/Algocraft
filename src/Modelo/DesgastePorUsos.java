package Modelo;

public class DesgastePorUsos extends Desgaste{
    private int usos;
    private int usosMaximos;

    public DesgastePorUsos(int cantDeUsos){
        usos = 0;
        usosMaximos = cantDeUsos;
    }

    @Override
    double desgastar(int durabilidad, int fuerza,Material material){
        usos += 1;
        if (usos >= usosMaximos) {return 0;}
        return durabilidad;
    }

    @Override
    public double desgastar(int durabilidad, int fuerza, Diamante material){
        usos += 1;
        if (usos >= usosMaximos) {return 0;}
        return durabilidad;
    }
}
