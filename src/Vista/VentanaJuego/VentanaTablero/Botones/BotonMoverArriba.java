package Vista.VentanaJuego.VentanaTablero.Botones;

import Controlador.BotonesHandlers.BotonMoverArribaHandler;
import Modelo.ElementosJugador.Jugador;
import Vista.Ventana;
import javafx.scene.control.Button;

public class BotonMoverArriba extends Button {

    private Jugador jugador;
    private Ventana ventana;

    public BotonMoverArriba(Ventana ventana, Jugador jugador) {
        this.setText("↑");
        this.jugador = jugador;
        this.ventana = ventana;

        BotonMoverArribaHandler handler = new BotonMoverArribaHandler(this);

        this.setOnAction(handler);
        }

    public Jugador obtenerJugador(){
        return jugador;
    }

    public Ventana obtenerVentana(){
        return ventana;
    }

}
