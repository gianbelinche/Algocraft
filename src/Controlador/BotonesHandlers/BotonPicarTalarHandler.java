package Controlador.BotonesHandlers;

import Jugador.Jugador;
import Vista.Ventana;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonPicarTalarHandler implements EventHandler<ActionEvent> {

    private final Jugador jugador;
    private final Ventana ventana;

    public BotonPicarTalarHandler(Ventana ventana, Jugador jugador) {
        this.jugador = jugador;
        this.ventana = ventana;
    }

    @Override
    public void handle(ActionEvent event) {
        jugador.recoger();
        ventana.actualizarImagen();
    }

}
