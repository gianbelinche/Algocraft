package Vista.VentanaPrincipal;

import Controlador.BotonesHandlers.ExitButtonHandler;
import Controlador.BotonesHandlers.StartButtonHandler;
import Vista.Ventana;
import javafx.geometry.Pos;
import Vista.VentanaPrincipal.Botones.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class TitleLayout extends StackPane {

    public TitleLayout(Stage stage, Ventana ventana) {

        //Creo Botones
        StartButton startButton = new StartButton(stage,ventana);
        StartButtonHandler startButtonHandler = new StartButtonHandler(stage,ventana);
        startButton.setOnAction(startButtonHandler);

        ExitButton exitButton = new ExitButton(stage);
        ExitButtonHandler exitButtonHandler = new ExitButtonHandler(stage,exitButton);
        exitButton.setOnAction(exitButtonHandler);

        VBox contenedorBotones = new VBox(startButton, exitButton);
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
