package Modelo;

public interface Almacenable {
    abstract boolean almacenar(Almacenable objeto);

    abstract Almacenable obtener();
}


