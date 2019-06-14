package Vista;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FirstLayout extends StackPane {

    public FirstLayout() throws FileNotFoundException {
        //Creo Botones
        Button startButton = new StartButton();
        Button exitButton = new ExitButton();

        VBox contenedorBotones = new VBox(startButton, exitButton);
        contenedorBotones.setSpacing(25);
        contenedorBotones.setAlignment(Pos.CENTER);

        //Cargo Imagen
        FileInputStream input = new FileInputStream("C:\\Users\\user\\Desktop\\Algoritmos 3\\TP2\\src\\Vista\\Prueba.png");

        Image image = new Image(input);

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
