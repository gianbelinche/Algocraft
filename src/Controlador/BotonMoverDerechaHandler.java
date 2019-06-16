package Controlador;

import Vista.BotonMoverDerecha;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class BotonMoverDerechaHandler implements EventHandler<ActionEvent> {
    BotonMoverDerecha button;
    public BotonMoverDerechaHandler(BotonMoverDerecha button){
        this.button = button;
    }

    public void handle(ActionEvent event){
        button.obtenerJugador().moverDerecha();
        button.obtenerVentana().actualizarImagen();

    }
}
