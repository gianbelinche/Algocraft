package Vista;

import Controlador.MainHandler;
import Modelo.Juego;
import Vista.VentanaJuego.VentanaInventario.InventarioLayout;
import Vista.VentanaJuego.VentanaTablero.MainLayout;
import Vista.VentanaPrincipal.TitleLayout;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.File;

public class Ventana extends Application {

    private Juego juego;
    private Dibujante dibujante;
    private double anchoPantalla;
    private double altoPantalla;


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

        mainStage.setTitle("Main");
        Group root = new Group();

        Rectangle2D bordesPantalla = Screen.getPrimary().getVisualBounds();
        anchoPantalla = bordesPantalla.getWidth();
        altoPantalla = bordesPantalla.getHeight();
        Scene mainScene = new Scene( root, anchoPantalla, altoPantalla);

        mainStage.setScene(mainScene);

        //Creo el layout del inventario
        InventarioLayout inventarioLayout = new InventarioLayout(mainStage,juego);

        //Creo tablero de juego
        Canvas canvas = new Canvas(anchoPantalla,altoPantalla);
        dibujante = new Dibujante(canvas.getGraphicsContext2D(),anchoPantalla,altoPantalla);

        //Creo fondo principal
        MainLayout mainLayout = new MainLayout(mainStage,juego,this, inventarioLayout);

        root.getChildren().add(canvas);
        root.getChildren().add(mainLayout);
        root.getChildren().add(inventarioLayout);

        mainScene.setOnKeyPressed(new MainHandler(juego.obtenerJugador(),this, inventarioLayout));

        actualizarImagen();

    }

    public void actualizarImagen(){
        dibujante.dibujar();
    }

    public void cambiarImagenJugador(Image imagen){
        dibujante.cambiarImagenJugador(imagen);
    }

}
