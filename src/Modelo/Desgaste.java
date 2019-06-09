package Modelo;

public interface Desgaste {

    double desgastar(int durabilidad, int fuerza,Material material);

    double desgastar(int durabilidad, int fuerza,Diamante material);
}
