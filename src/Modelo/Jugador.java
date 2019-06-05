package Modelo;

public class Jugador {

    private Constructor constructor = new Constructor();
    private Hacha hachaDeMadera = constructor.crearHachaDeMadera();
    private Herramienta herramientaEquipada = hachaDeMadera;

    public Herramienta herramientaEquipada() {
        return herramientaEquipada;
    }
}
