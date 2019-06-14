package Vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ventana extends Application {

    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Ventana Principal");

        StackPane layout = new StackPane();

        Button startButton = new StartButton();
        Button exitButton = new ExitButton();

        VBox contenedorBotones = new VBox(startButton, exitButton);
        contenedorBotones.setSpacing(15);

        layout.getChildren().add(contenedorBotones);

        Scene scene = new Scene(layout);
        primaryStage.setScene(scene);

        primaryStage.show();
    }
}
