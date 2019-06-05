package Modelo;

public class Jugador {

    private Herramienta herramientaEquipada;

    public Jugador(){
        Constructor constructor = new Constructor();
        herramientaEquipada = constructor.crearHachaDeMadera();
    }

    public Herramienta herramientaEquipada() {
        return herramientaEquipada;
    }
}
