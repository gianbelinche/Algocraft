package Vista.VentanaPrincipal;

import Controlador.BotonesHandlers.BotonSalirHandler;
import Controlador.BotonesHandlers.BotonJugarHandler;
import Vista.Ventana;
import javafx.geometry.Pos;
import Vista.VentanaPrincipal.Botones.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class TitleLayout extends StackPane {

    public TitleLayout(Stage stage, Ventana ventana) {

        //Creo Botones
        BotonJugar botonJugar = new BotonJugar(stage,ventana);
        BotonJugarHandler botonJugarHandler = new BotonJugarHandler(stage,ventana);
        botonJugar.setOnAction(botonJugarHandler);

        BotonSalir botonSalir = new BotonSalir(stage);
        BotonSalirHandler botonSalirHandler = new BotonSalirHandler(stage);
        botonSalir.setOnAction(botonSalirHandler);

        VBox contenedorBotones = new VBox(botonJugar, botonSalir);
        contenedorBotones.setSpacing(25);
        contenedorBotones.setAlignment(Pos.CENTER);

        //Cargo Imagen
        Image image = new Image("file:src/Vista/Imagenes/MainTitle.png");

        BackgroundImage backgroundImage = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(1.0, 1.0, true, true, false, false));
        //Adapto tamaño de imagen a tamaño de pantalla

        Background background = new Background(backgroundImage);
        contenedorBotones.setBackground(background);

        this.getChildren().add(contenedorBotones);
    }

}
