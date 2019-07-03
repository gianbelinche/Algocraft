package Vista.VentanaJuego.VentanaTablero.Botones;

import Controlador.BotonesHandlers.BotonAyudaHandler;
import Vista.Ventana;
import javafx.scene.control.Button;

public class BotonAyuda extends Button {

        public BotonAyuda(Ventana ventana){
            this.setText("Ayuda");
            BotonAyudaHandler botonAyudaHandler = new BotonAyudaHandler(ventana);
            this.setOnAction(botonAyudaHandler);
        }

}
