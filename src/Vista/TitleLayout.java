package Vista;

import Controlador.ExitButtonHandler;
import Controlador.StartButtonHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TitleLayout extends StackPane {

    public TitleLayout(Stage stage) {
        //Creo Botones

        Button startButton = new StartButton(stage, this);
        Button exitButton = new ExitButton(stage);

        VBox contenedorBotones = new VBox(startButton, exitButton);
        //startButton.prefHeightProperty().bind(contenedorBotones.heightProperty());
        contenedorBotones.setSpacing(25);
        contenedorBotones.setAlignment(Pos.CENTER);

        //Cargo Imagen
        Image image = new Image("file:src/Vista/Imagenes/Prueba.jpg");

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
