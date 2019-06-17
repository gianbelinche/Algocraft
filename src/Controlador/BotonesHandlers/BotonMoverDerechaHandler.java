package Controlador.BotonesHandlers;

import Vista.VentanaJuego.VentanaTablero.BotonMoverDerecha;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

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
