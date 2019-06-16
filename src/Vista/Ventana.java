package Vista;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Background;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.File;
import Modelo.Juego;
public class Ventana extends Application {


    private Juego juego;
    private Stage escenario;
    private Scene escena;
    private GraphicsContext terreno;
    double pantallaAncho;
    double pantallaAlto;

    public static void main(String[] args) {
        launch(args);
    }

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
        //Inicializacion de juego
        juego = new Juego();

        escenario = mainStage;
        mainStage.setTitle("Main");

        Group root = new Group();


        Scene mainScene = new Scene( root, 4000, 4000);
        mainStage.setScene(mainScene);

        Canvas canvas = new Canvas(5000,4000);
        terreno = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);

        MainLayout mainLayout = new MainLayout(mainStage);
        root.getChildren().add(mainLayout);

        actualizarImagen();

    }

    public void actualizarImagen(){
        terreno.setFill(Color.LIGHTCYAN);
        terreno.fillRect(0,0,3000,3000);
        juego.dibujar(terreno);

    }
}
