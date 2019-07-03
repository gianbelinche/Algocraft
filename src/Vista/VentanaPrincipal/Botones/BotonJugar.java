package Vista.VentanaPrincipal.Botones;

import Controlador.BotonesHandlers.BotonJugarHandler;
import Vista.Ventana;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class BotonJugar extends Button {

    public BotonJugar(Stage stage, Ventana ventana){
        BotonJugarHandler botonJugarHandler = new BotonJugarHandler(stage,ventana);
        this.setOnAction(botonJugarHandler);

        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

        Image image = new Image("file:src/Vista/Imagenes/BotonPlay.png");
        this.setPrefWidth(primaryScreenBounds.getWidth()*0.15);
        this.setPrefHeight(primaryScreenBounds.getHeight()*0.08);

        BackgroundImage backgroundImage = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(1.0, 1.0, true, true, false, false));
        //Adapto tamaño de imagen a tamaño de pantalla

        Background background = new Background(backgroundImage);
        this.setBackground(background);
    }

}
