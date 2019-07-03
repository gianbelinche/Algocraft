package Vista.VentanaJuego.VentanaTablero.Botones;

import Controlador.BotonesHandlers.BotonMoverIzquierdaHandler;
import Modelo.ElementosJugador.Jugador;
import Vista.Ventana;
import javafx.scene.control.Button;

public class BotonMoverIzquierda extends Button {

    private Jugador jugador;
    private Ventana ventana;

    public BotonMoverIzquierda(Ventana ventana, Jugador jugador){

        this.setText("←");
        this.jugador = jugador;
        this.ventana = ventana;
        this.setOnAction(new BotonMoverIzquierdaHandler(this));
    }

    public Jugador obtenerJugador(){
        return jugador;
    }

    public Ventana obtenerVentana(){
        return ventana;
    }

}
