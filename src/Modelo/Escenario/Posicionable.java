package Modelo.Escenario;

import javafx.scene.canvas.GraphicsContext;

public interface Posicionable {

    abstract int estaLibre();

    abstract void establecerPosicion(Posicion nuevaPosicion);

    abstract boolean esIgual(Posicionable otroPosicionable);

    abstract void dibujar(int x, int y, GraphicsContext gc);
}
