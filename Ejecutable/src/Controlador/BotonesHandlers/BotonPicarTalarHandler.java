package Controlador.BotonesHandlers;


import Vista.CajaMusical;
import Modelo.ElementosJugador.Jugador;
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
        try{
            CajaMusical.reproducirMusicaDeHacha();
        }
        catch(Exception e){}
        jugador.recoger();
        ventana.actualizarImagen();
    }

}
