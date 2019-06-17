package Vista;

import Controlador.BotonMoverArribaHandler;
import Modelo.Jugador;
import javafx.scene.control.Button;

public class BotonMoverArriba extends Button {
    Jugador jugador;
    Ventana ventana;

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
