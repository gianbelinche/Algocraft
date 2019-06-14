package Vista;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Ventana extends Application {

    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        primaryStage.setTitle("Ventana Principal");

        StackPane layout = new StackPane();

        Button startButton = new StartButton();
        Button exitButton = new ExitButton();

        VBox contenedorBotones = new VBox(startButton, exitButton);
        contenedorBotones.setSpacing(15);
        contenedorBotones.setAlignment(Pos.CENTER);

        FileInputStream input = new FileInputStream("C:\\Users\\user\\Desktop\\Algoritmos 3\\TP2\\src\\Vista\\Prueba.png");

        Image image = new Image(input);

        BackgroundImage backgroundImage = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

        Background background = new Background(backgroundImage);

        contenedorBotones.setBackground(background);

        layout.getChildren().add(contenedorBotones);

        Scene scene = new Scene(layout, 512,250);
        primaryStage.setScene(scene);

        primaryStage.show();
    }
}
