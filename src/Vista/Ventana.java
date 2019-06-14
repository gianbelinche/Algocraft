package Vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class Ventana extends Application {

    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        primaryStage.setTitle("Ventana Principal");

        StackPane layout = new FirstLayout();

        Scene scene = new Scene(layout, 512,250);
        primaryStage.setScene(scene);

        primaryStage.show();
    }
}
