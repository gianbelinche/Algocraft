package Controlador.BotonesHandlers;

import Vista.VentanaJuego.VentanaTablero.Botones.BotonMoverDerecha;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;

public class BotonMoverDerechaHandler implements EventHandler<ActionEvent> {
    BotonMoverDerecha button;
    public BotonMoverDerechaHandler(BotonMoverDerecha button){
        this.button = button;
    }

    public void handle(ActionEvent event){
        button.obtenerJugador().moverDerecha();
        button.obtenerVentana().cambiarImagenJugador(new Image("file:src/Vista/Imagenes/JugadorDerecha.png"));
        button.obtenerVentana().actualizarImagen();

    }
}
