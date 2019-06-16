package Controlador;

import Vista.BotonMoverAbajo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class BotonMoverAbajoHandler implements EventHandler<ActionEvent> {
    BotonMoverAbajo button;
    public BotonMoverAbajoHandler(BotonMoverAbajo button){
        this.button = button;
    }

    public void handle(ActionEvent event){
        button.obtenerJugador().moverAbajo();

    }
}
