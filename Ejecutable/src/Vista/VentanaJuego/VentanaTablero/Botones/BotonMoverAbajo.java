package Vista.VentanaJuego.VentanaTablero.Botones;

import Controlador.BotonesHandlers.BotonMoverAbajoHandler;
import Modelo.ElementosJugador.Jugador;
import Vista.Ventana;
import javafx.scene.control.Button;

public class BotonMoverAbajo extends Button {

    private Jugador jugador;
    private Ventana ventana;

    public BotonMoverAbajo(Ventana ventana, Jugador jugador){
        this.jugador = jugador;
        this.setText("↓");
        this.ventana = ventana;

        BotonMoverAbajoHandler handler = new BotonMoverAbajoHandler(this);
        this.setOnAction(handler);
    }
    public Jugador obtenerJugador(){
        return jugador;
    }

    public Ventana obtenerVentana(){
        return ventana;
    }

}