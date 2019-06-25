package Vista.VentanaJuego.VentanaInventario.Botones;

import Controlador.BotonesHandlers.BotonInventarioHandler;
import Modelo.Materiales.Material;
import Vista.VentanaJuego.VentanaInventario.MaterialSeleccionado;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class BotonInventario extends Button {
    BotonInventarioHandler botonInventarioHandler;

    public BotonInventario(MaterialSeleccionado materialSeleccionado){

        Image image = new Image("file:src/Vista/Imagenes/BotonVacio.png");

        BackgroundImage backgroundImage = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(1.0, 1.0, true, true, false, false));
        this.setBackground(new Background(backgroundImage));

        botonInventarioHandler = new BotonInventarioHandler(materialSeleccionado);
        this.setOnAction(botonInventarioHandler);
    }
    public void setMaterial(Material miMaterial){
        botonInventarioHandler.setMaterial(miMaterial);
    }
}
