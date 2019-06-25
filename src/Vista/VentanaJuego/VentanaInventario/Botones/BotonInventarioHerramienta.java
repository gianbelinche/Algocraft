package Vista.VentanaJuego.VentanaInventario.Botones;

import Controlador.BotonesHandlers.BotonInventarioHerramientaHandler;
import Modelo.Herramientas.Herramienta;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class BotonInventarioHerramienta extends Button {

    BotonInventarioHerramientaHandler botonInventarioHerramientaHandler;
    Herramienta miHerramienta;

    public BotonInventarioHerramienta(Herramienta miHerramienta, Image imagen){

        BackgroundImage backgroundImage = new BackgroundImage(imagen,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(1.0, 1.0, true, true, false, false));
        this.setBackground(new Background(backgroundImage));

        this.miHerramienta = miHerramienta;
        botonInventarioHerramientaHandler = new BotonInventarioHerramientaHandler(miHerramienta);
        this.setOnAction(botonInventarioHerramientaHandler);

        this.setPrefSize(56,56);
    }
}
