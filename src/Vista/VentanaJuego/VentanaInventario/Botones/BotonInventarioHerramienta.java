package Vista.VentanaJuego.VentanaInventario.Botones;

import Controlador.BotonesHandlers.BotonInventarioHerramientaHandler;
import Modelo.Herramientas.Herramienta;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class BotonInventarioHerramienta extends Button {

    BotonInventarioHerramientaHandler botonInventarioHerramientaHandler;
    Herramienta miHerramienta;
    int cantidad;

    public BotonInventarioHerramienta(Image imagen){

        BackgroundImage backgroundImage = new BackgroundImage(imagen,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(1.0, 1.0, true, true, false, false));
        this.setBackground(new Background(backgroundImage));

        botonInventarioHerramientaHandler = new BotonInventarioHerramientaHandler(miHerramienta);
        this.setOnAction(botonInventarioHerramientaHandler);

        this.setPrefSize(56,56);
    }

    public void setCantidadYHerramienta(int unaCantidad, Herramienta unaHerramienta){
        cantidad = unaCantidad;

        this.setText(Integer.toString(cantidad));
        this.setStyle("-fx-text-fill: rgb(252,246,255)");
        this.setAlignment(Pos.BOTTOM_RIGHT);

        this.miHerramienta = unaHerramienta;
    }
}
