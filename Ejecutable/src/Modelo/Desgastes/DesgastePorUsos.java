package Modelo.Desgastes;

import Modelo.Materiales.Diamante;
import Modelo.Materiales.Material;

public class DesgastePorUsos implements Desgaste {
    private int usos;
    private int usosMaximos;

    public DesgastePorUsos(int cantDeUsos){
        usos = 0;
        usosMaximos = cantDeUsos;
    }

    @Override
    public double desgastar(int durabilidad, int fuerza, Material material){
        usos += 1;
        if (usos >= usosMaximos) {return -1;}
        return durabilidad;
    }

    @Override
    public double desgastar(int durabilidad, int fuerza, Diamante material){
        usos += 1;
        if (usos >= usosMaximos) {return -1;}
        return durabilidad;
    }
}
