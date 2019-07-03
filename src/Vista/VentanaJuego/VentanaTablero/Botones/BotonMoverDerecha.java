package Vista.VentanaJuego.VentanaTablero.Botones;

import Controlador.BotonesHandlers.BotonMoverDerechaHandler;
import Modelo.ElementosJugador.Jugador;
import Vista.Ventana;
import javafx.scene.control.Button;

public class BotonMoverDerecha extends Button {

    private Jugador jugador;
    private Ventana ventana;

    public BotonMoverDerecha(Ventana ventana, Jugador jugador) {
        this.setText("→");
        this.jugador = jugador;
        this.ventana = ventana;
        BotonMoverDerechaHandler handler = new BotonMoverDerechaHandler(this);
        this.setOnAction(handler);
    }

    public Jugador obtenerJugador(){
        return jugador;
    }

    public Ventana obtenerVentana(){
        return ventana;
    }
}