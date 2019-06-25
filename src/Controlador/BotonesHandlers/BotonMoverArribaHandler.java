package Controlador.BotonesHandlers;

import Vista.VentanaJuego.VentanaTablero.Botones.BotonMoverArriba;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;

public class BotonMoverArribaHandler implements EventHandler<ActionEvent> {
    BotonMoverArriba button;
    public BotonMoverArribaHandler(BotonMoverArriba button){
        this.button = button;
    }

    public void handle(ActionEvent event){
        button.obtenerJugador().moverArriba();
        button.obtenerVentana().cambiarImagenJugador(new Image("file:src/Vista/Imagenes/JugadorArriba.png"));
        button.obtenerVentana().actualizarImagen();

    }
}
