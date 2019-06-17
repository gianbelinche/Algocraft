package Controlador;

import Vista.VentanaJuego.VentanaTablero.BotonMoverArriba;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonMoverArribaHandler implements EventHandler<ActionEvent> {
    BotonMoverArriba button;
    public BotonMoverArribaHandler(BotonMoverArriba button){
        this.button = button;
    }

    public void handle(ActionEvent event){
        button.obtenerJugador().moverArriba();
        button.obtenerVentana().actualizarImagen();

    }
}
