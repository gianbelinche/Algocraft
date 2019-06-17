package Controlador;

import Vista.VentanaJuego.VentanaTablero.BotonMoverAbajo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonMoverAbajoHandler implements EventHandler<ActionEvent> {
    BotonMoverAbajo button;
    public BotonMoverAbajoHandler(BotonMoverAbajo button){
        this.button = button;
    }

    public void handle(ActionEvent event){
        button.obtenerJugador().moverAbajo();
        button.obtenerVentana().actualizarImagen();

    }
}
