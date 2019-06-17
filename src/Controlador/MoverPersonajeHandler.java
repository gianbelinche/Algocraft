package Controlador;

import Modelo.Jugador;
import Vista.Ventana;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class MoverPersonajeHandler implements EventHandler<KeyEvent> {
    Jugador jugador;
    Ventana ventana;
    public MoverPersonajeHandler(Jugador jugador, Ventana vemtana){
        this.jugador = jugador;
        this.ventana = vemtana;
    }
    public void handle(KeyEvent key){
        if (key.getCode() == KeyCode.A || key.getCode() == KeyCode.LEFT) {
            jugador.moverIzquierda();
        }
        if (key.getCode() == KeyCode.S || key.getCode() == KeyCode.DOWN){
            jugador.moverAbajo();
        }
        if (key.getCode() == KeyCode.D || key.getCode() == KeyCode.RIGHT){
            jugador.moverDerecha();
        }
        if (key.getCode() == KeyCode.W || key.getCode() == KeyCode.UP){
            jugador.moverArriba();
        }
        ventana.actualizarImagen();
    }

}