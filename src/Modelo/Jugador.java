package Modelo;

public class Jugador {

    private Herramienta herramientaEquipada;
    private Posicion posicion;

    public Jugador(Tablero tablero){
        Constructor constructor = new Constructor();
        herramientaEquipada = constructor.crearHachaDeMadera();
        posicion = new Posicion(5, 5, tablero);
    }

    public Herramienta herramientaEquipada() {
        return herramientaEquipada;
    }
    /*
    public void moverDerecha(){
        posicion.moverDerecha();
    }

    public void moverIzquierda(){
        posicion.moverIzquierda();
    }
    public void moverArriba(){
        posicion.moverArriba();
    }
    public void moverAbajo(){
        posicion.moverAbajo();
    }
     */
}
