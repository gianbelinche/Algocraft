package Vista;

import Modelo.Jugador;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class BotonMoverAbajo extends Button {
    Jugador jugador;
    Ventana ventana;
    public BotonMoverAbajo(Ventana ventana, Jugador jugador){
        this.jugador = jugador;
        this.setText("↓");
        this.ventana = ventana;
    }
    public Jugador obtenerJugador(){
        return jugador;
    }

    public Ventana obtenerVentana(){
        return ventana;
    }

}