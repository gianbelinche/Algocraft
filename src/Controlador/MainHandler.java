package Controlador;

import Modelo.Jugador;
import Vista.Ventana;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class MainHandler implements EventHandler<KeyEvent>{

        Jugador jugador;
        Ventana ventana;

        public MainHandler(Jugador jugador, Ventana vemtana){
            this.jugador = jugador;
            this.ventana = vemtana;

        }

        public void handle(KeyEvent key){
            if (key.getCode() == KeyCode.A ) {
                jugador.moverIzquierda();
            }
            else if (key.getCode() == KeyCode.S ){
                jugador.moverAbajo();
            }
            else if (key.getCode() == KeyCode.D ){
                jugador.moverDerecha();
            }
            else if (key.getCode() == KeyCode.W ){
                jugador.moverArriba();
            }
            else if (key.getCode() == KeyCode.P) {
                jugador.recoger();
            }/*
            else if (key.getCode() == KeyCode.E) {
                inventario.setVisible(false);
            }*/
            ventana.actualizarImagen();
        }

}
