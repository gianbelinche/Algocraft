package Modelo;

public abstract class Desgaste {

    abstract double desgastar(int durabilidad, int fuerza,Material material);

    abstract double desgastar(int durabilidad, int fuerza,Diamante material);
}
