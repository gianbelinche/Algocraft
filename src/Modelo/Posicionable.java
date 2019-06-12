package Modelo;

interface Posicionable {

    abstract int estaLibre();

    abstract void establecerPosicion(Posicion nuevaPosicion);

    abstract boolean esIgual(Posicionable otroPosicionable);
}
