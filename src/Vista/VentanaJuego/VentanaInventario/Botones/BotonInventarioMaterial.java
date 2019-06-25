package Vista.VentanaJuego.VentanaInventario.Botones;

import Controlador.BotonesHandlers.BotonInventarioHandler;
import Modelo.Materiales.Material;
import Vista.VentanaJuego.VentanaInventario.MaterialSeleccionado;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class BotonInventarioMaterial extends Button {

    private int cantidad;
    BotonInventarioHandler botonInventarioHandler;

    public BotonInventarioMaterial(MaterialSeleccionado materialSeleccionado, Image imagen){

        Image image = imagen;

        BackgroundImage backgroundImage = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(1.0, 1.0, true, true, false, false));
        this.setBackground(new Background(backgroundImage));

        botonInventarioHandler = new BotonInventarioHandler(materialSeleccionado);
        this.setPrefSize(56,56);
        this.setOnAction(botonInventarioHandler);

        cantidad = 0;
        this.setText(Integer.toString(cantidad));
        this.setStyle("-fx-text-fill: rgb(252,246,255)");
        this.setAlignment(Pos.BOTTOM_RIGHT);
    }

    public void setMaterial(Material miMaterial){
        botonInventarioHandler.setMaterial(miMaterial);
    }
}
