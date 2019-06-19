package Controlador.BotonesHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ExitButtonHandler implements EventHandler<ActionEvent> {

    Stage stage;
    Button button;

    public ExitButtonHandler(Stage stage,Button button){
        this.stage = stage;
        this.button = button;
    }

    private int contador = 0;

    @Override
    public void handle(ActionEvent event) {
        Image image = new Image("file:src/Vista/Imagenes/Exit.png");
        if (contador == 0){
            image = new Image("file:src/Vista/Imagenes/Dont do it.png");
        }
        if (contador == 1){
            image = new Image("file:src/Vista/Imagenes/Please Dont.png");
        }

        if (contador == 2){
            image = new Image("file:src/Vista/Imagenes/I have a family.png");
        }
        if (contador > 2){
            stage.close();
        }
        BackgroundImage backgroundImage = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(1.0, 1.0, true, true, false, false));
        //Adapto tamaño de imagen a tamaño de pantalla
        Background background = new Background(backgroundImage);
        button.setBackground(background);
        contador += 1;
    }

}
