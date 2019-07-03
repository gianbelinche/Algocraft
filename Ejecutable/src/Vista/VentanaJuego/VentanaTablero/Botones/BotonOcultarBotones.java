package Vista.VentanaJuego.VentanaTablero.Botones;

import Controlador.BotonesHandlers.BotonOcultarBotonesHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class BotonOcultarBotones extends Button {

    public BotonOcultarBotones(HBox cajaCompleta){
        this.setText("Ocultar Botones");
        this.setTranslateX(15);
        this.setTranslateY(20);

        BotonOcultarBotonesHandler botonOcultarBotonesHandler = new BotonOcultarBotonesHandler(this, cajaCompleta);
        this.setOnAction(botonOcultarBotonesHandler);
    }

}
