package Vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;

public class Ventana extends Application {

    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Title");

        String musicFile = "src/Vista/Sonidos/C418  - Sweden - Minecraft Volume Alpha.mp3";     // For example

        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();

        StackPane titleLayout = new TitleLayout(primaryStage);

        Scene titleScene = new Scene(titleLayout, 512,250);
        primaryStage.setScene(titleScene);
        primaryStage.show();
    }

    public void mainStart(Stage mainStage){
        mainStage.setTitle("Main");

        StackPane mainLayout = new MainLayout(mainStage);
        StackPane inventarioLayout = new InventarioLayout((mainStage));

        Scene mainScene = new Scene(mainLayout, mainStage.getWidth(), mainStage.getHeight());
        //Scene inventarioScene = new Scene(inventarioLayout, mainStage.getWidth(), mainStage.getHeight());

        mainStage.setScene(mainScene);
       // mainStage.setScene(inventarioScene);

        //inventarioLayout.setVisible(true);

        mainStage.show();
    }
}
