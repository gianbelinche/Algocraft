package Vista;

import Controlador.BotonMoverIzquierdaHandler;
import Modelo.Jugador;
import javafx.scene.control.Button;

public class BotonMoverIzquierda extends Button {


    Jugador jugador;
    Ventana ventana;

    public BotonMoverIzquierda(Ventana ventana,Jugador jugador){

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
