package Controlador.BotonesHandlers;

import Vista.VentanaJuego.VentanaTablero.Botones.BotonMoverIzquierda;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;

public class BotonMoverIzquierdaHandler implements EventHandler<ActionEvent> {
    BotonMoverIzquierda button;
    public BotonMoverIzquierdaHandler(BotonMoverIzquierda button){
        this.button = button;
    }

    public void handle(ActionEvent event){
        button.obtenerJugador().moverIzquierda();
        button.obtenerVentana().cambiarImagenJugador(new Image("file:src/Vista/Imagenes/JugadorIzquierda.png"));
        button.obtenerVentana().actualizarImagen();

    }

}
