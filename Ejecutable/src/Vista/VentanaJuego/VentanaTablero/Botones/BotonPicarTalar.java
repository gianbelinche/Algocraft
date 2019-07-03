package Vista.VentanaJuego.VentanaTablero.Botones;

import Controlador.BotonesHandlers.BotonPicarTalarHandler;
import Modelo.ElementosJugador.Jugador;
import Vista.Ventana;
import javafx.scene.control.Button;

public class BotonPicarTalar extends Button {

    public BotonPicarTalar(Ventana ventana, Jugador jugador){
        this.setText("Picar/Talar");
        BotonPicarTalarHandler botonPicarTalarHandler = new BotonPicarTalarHandler(ventana, jugador);
        this.setOnAction(botonPicarTalarHandler);
    }

}
