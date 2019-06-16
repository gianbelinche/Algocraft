package Vista;

import Modelo.Jugador;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class BotonMoverAbajo extends Button {
    Jugador jugador;
    public BotonMoverAbajo(Stage stage, Jugador jugador){
        this.jugador = jugador;
        this.setText("~");
    }
    public Jugador obtenerJugador(){
        return jugador;
    }

}