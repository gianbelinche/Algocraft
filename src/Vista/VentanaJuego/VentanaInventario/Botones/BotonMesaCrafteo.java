package Vista.VentanaJuego.VentanaInventario.Botones;

import Controlador.BotonesHandlers.BotonMesaCrafteoHandler;
import Modelo.Almacenable;
import javafx.scene.control.Button;

public class BotonMesaCrafteo extends Button {
    public BotonMesaCrafteo(Almacenable materialSeleccionado, int x, int y){
        setText("");
        //Transparenta el boton
        //setStyle("-fx-background-color: transparent");
        BotonMesaCrafteoHandler botonMesaHandler = new BotonMesaCrafteoHandler(materialSeleccionado, x, y);
        this.setOnAction(botonMesaHandler);
    }
}
