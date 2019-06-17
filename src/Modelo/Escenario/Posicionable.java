package Modelo.Escenario;

import javafx.scene.canvas.GraphicsContext;

public interface Posicionable {

    int estaLibre();

    void establecerPosicion(Posicion nuevaPosicion);

    boolean esIgual(Posicionable otroPosicionable);

    void dibujar(int x, int y, GraphicsContext gc);
}
