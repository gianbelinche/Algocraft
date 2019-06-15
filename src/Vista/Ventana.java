package Vista;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Screen;
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

        TitleLayout titleLayout = new TitleLayout(primaryStage);

        Scene titleScene = new Scene(titleLayout);
        primaryStage.setScene(titleScene);

        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

        //set Stage boundaries to visible bounds of the main screen
        primaryStage.setX(primaryScreenBounds.getMinX());
        primaryStage.setY(primaryScreenBounds.getMinY());
        primaryStage.setWidth(primaryScreenBounds.getWidth());
        primaryStage.setHeight(primaryScreenBounds.getHeight());

        primaryStage.setResizable(false);

        primaryStage.show();
    }

    public void mainStart(Stage mainStage){
        mainStage.setTitle("Main");

        MainLayout mainLayout = new MainLayout(mainStage);

        Scene mainScene = new Scene(mainLayout, mainStage.getWidth(), mainStage.getHeight());
        mainStage.setScene(mainScene);

        mainStage.show();
    }
}
