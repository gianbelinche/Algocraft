package Vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;

public class Ventana extends Application {

    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        primaryStage.setTitle("Ventana Principal");

        String musicFile = "src/Vista/Sonidos/C418  - Sweden - Minecraft Volume Alpha.mp3";     // For example

        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();

        StackPane layout = new FirstLayout(primaryStage);



        Scene scene = new Scene(layout, 512,250);
        primaryStage.setScene(scene);

        primaryStage.show();
    }
}
