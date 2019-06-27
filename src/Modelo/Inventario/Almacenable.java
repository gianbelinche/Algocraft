package Modelo.Inventario;

public interface Almacenable {
    boolean almacenar(Almacenable objeto);

    Almacenable obtener();
}


