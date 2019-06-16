package Vista;

import Controlador.BotonMoverDerechaHandler;
import Modelo.Jugador;
import javafx.scene.control.Button;

public class BotonMoverDerecha extends Button {

    Jugador jugador;
    Ventana ventana;

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