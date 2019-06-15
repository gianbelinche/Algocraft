package Vista;

import Controlador.StartButtonHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class StartButton extends Button {

    public StartButton(Stage stage){
        StartButtonHandler startButtonHandler = new StartButtonHandler(stage);
        this.setOnAction(startButtonHandler);

        Image image = new Image("file:src/Vista/Imagenes/BotonPlay.jpg");

        BackgroundImage backgroundImage = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(1.0, 1.0, true, true, false, false));

        Background background = new Background(backgroundImage);

        //Seteo tamaño a 5% de pantalla
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        this.setPrefWidth(primaryScreenBounds.getWidth()*0.05);
        this.setPrefHeight(primaryScreenBounds.getHeight()*0.05);
    }

}
