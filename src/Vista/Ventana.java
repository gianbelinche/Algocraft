package Vista;

import Controlador.MainHandler;
import Modelo.Juego;
import Vista.VentanaJuego.VentanaInventario.InventarioLayout;
import Vista.VentanaJuego.VentanaTablero.BotonHerramientaEquipada;
import Vista.VentanaJuego.VentanaTablero.MainLayout;
import Vista.VentanaPrincipal.TitleLayout;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Ventana extends Application {

    private Juego juego;
    private Dibujante dibujante;
    private double anchoPantalla;
    private double altoPantalla;
    private Group root;
    private BotonHerramientaEquipada botonHerramientaEquipada;


    public static void main(String[] args) {
        launch(args);
    }

    public void ajustarEscenario(Stage escenario){
        Rectangle2D bordesPantalla = Screen.getPrimary().getVisualBounds();

        anchoPantalla = bordesPantalla.getWidth();
        altoPantalla = bordesPantalla.getHeight();
        escenario.setX(bordesPantalla.getMinX());
        escenario.setY(bordesPantalla.getMinY());
        escenario.setWidth(anchoPantalla);
        escenario.setHeight(altoPantalla);
        escenario.setResizable(false);
    }

    @Override
    public void start(Stage primaryStage) {

        CajaMusical.reproducirMusicaDeFondo();
        TitleLayout titleLayout = new TitleLayout(primaryStage,this);
        Scene titleScene = new Scene(titleLayout);
        primaryStage.setScene(titleScene);
        ajustarEscenario(primaryStage);
        primaryStage.show();
    }

    public void mainStart(Stage mainStage){

        juego = new Juego(this);

        Group root = new Group();
        this.root = root;
        Scene mainScene = new Scene( root, anchoPantalla, altoPantalla);
        mainStage.setScene(mainScene);

        //Creo boton para ver herramienta equipada
        this.botonHerramientaEquipada = new BotonHerramientaEquipada(juego.obtenerJugador());

        //Creo el layout del inventario
        InventarioLayout inventarioLayout = new InventarioLayout(mainStage,juego);

        //Creo tablero de juego
        Canvas canvas = new Canvas(anchoPantalla,altoPantalla);
        dibujante = new Dibujante(canvas.getGraphicsContext2D(),anchoPantalla,altoPantalla);

        //Creo fondo principal
        MainLayout mainLayout = new MainLayout(mainStage,juego,this, inventarioLayout, botonHerramientaEquipada);

        root.getChildren().add(canvas);
        root.getChildren().add(mainLayout);
        root.getChildren().add(inventarioLayout);

        mainScene.setOnKeyReleased(new MainHandler(juego.obtenerJugador(),this, inventarioLayout));
        actualizarImagen();

    }

    public void actualizarImagen(){
        dibujante.dibujar();
        botonHerramientaEquipada.actualizarImagen();
    }

    public void cambiarImagenJugador(Image imagen){
        dibujante.cambiarImagenJugador(imagen);
    }

    public void mostrarVictoria(){

        Image image = new Image("file:src/Vista/Imagenes/ganaste.png");
        Canvas canvas = new Canvas(anchoPantalla,altoPantalla);
        canvas.getGraphicsContext2D().drawImage(image,anchoPantalla/100 + 720,altoPantalla/100 +100);

        root.getChildren().add(canvas);

        CajaMusical.reproducirMusicaGanar();

    }
}
