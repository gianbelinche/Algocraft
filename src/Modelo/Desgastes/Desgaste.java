package Modelo.Desgastes;

import Modelo.Materiales.Diamante;
import Modelo.Materiales.Material;

public interface Desgaste {

    double desgastar(int durabilidad, int fuerza, Material material);

    double desgastar(int durabilidad, int fuerza, Diamante material);
}
