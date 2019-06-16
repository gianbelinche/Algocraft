package Vista;

import Modelo.Jugador;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class BotonMoverArriba extends Button {
    Jugador jugador;
    Ventana ventana;

    public BotonMoverArriba(Ventana ventana, Jugador jugador) {
        this.setText("^");
        this.jugador = jugador;
        this.ventana = ventana;
        }

    public Jugador obtenerJugador(){
        return jugador;
    }

    public Ventana obtenerVentana(){
        return ventana;
    }


}
