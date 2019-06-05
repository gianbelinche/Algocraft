package Modelo;

public class DesgastePorUsos extends Desgaste{
    private int usos;
    private int usosMaximos;
    public DesgastePorUsos(int CantDeUsos){
        usos = 0;
        usosMaximos = CantDeUsos;
    }

    double desgastar(int durabilidad, int fuerza){
        usos += 1;
        if (usos >= usosMaximos) {return 0;}
        return durabilidad;
    }
}
