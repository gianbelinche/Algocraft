package Modelo;

public class Jugador implements Posicionable{

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

    @Override
    public int estaLibre() {
        return 0;
    }

    @Override
    public void establecerPosicion(Posicion nuevaPosicion){
        posicion = nuevaPosicion;
    }

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
}
