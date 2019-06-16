package Vista;


import Controlador.BotonMoverAbajoHandler;
import Controlador.BotonMoverArribaHandler;
import Controlador.SalirDeInventarioHandler;
import Modelo.Juego;
import javafx.geometry.Pos;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.shape.Box;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class MainLayout extends Pane {

    public MainLayout(Stage mainStage, Juego juego,Ventana ventana) {

        //Creo botones de movimiento
        BotonMoverArriba botonMoverArriba = new BotonMoverArriba(ventana,juego.obtenerJugador());
        botonMoverArriba.setOnAction(new BotonMoverArribaHandler(botonMoverArriba));
        botonMoverArriba.setTranslateX(28); //HARDCODEO

        BotonMoverAbajo botonMoverAbajo = new BotonMoverAbajo(ventana,juego.obtenerJugador());
        botonMoverAbajo.setOnAction(new BotonMoverAbajoHandler(botonMoverAbajo));

        BotonMoverDerecha botonMoverDerecha = new BotonMoverDerecha(mainStage);
        BotonMoverIzquierda botonMoverIzquierda = new BotonMoverIzquierda(mainStage);

        HBox botonesMovimientoAbajo = new HBox(botonMoverIzquierda, botonMoverAbajo,botonMoverDerecha);
        VBox botonesMovimientoCompleto = new VBox(botonMoverArriba, botonesMovimientoAbajo);

        botonesMovimientoCompleto.setSpacing(10);

        InventarioLayout inventarioLayout = new InventarioLayout((mainStage));

        //Creo boton inventario
        VBox contenedorBotones = new VBox();
        BotonEntrarInventario botonEntrarInventario = new BotonEntrarInventario(inventarioLayout, contenedorBotones);
        //ExitButton botonSalir = new ExitButton(mainStage);
        contenedorBotones.getChildren().addAll(botonEntrarInventario);
        this.setOnKeyPressed(new SalirDeInventarioHandler(inventarioLayout));

        VBox columnaBotones = new VBox(botonesMovimientoCompleto, contenedorBotones);
        columnaBotones.setSpacing(100);
        columnaBotones.setAlignment(Pos.CENTER);

        HBox cajaCompleta = new HBox(columnaBotones);
        cajaCompleta.setPrefSize(150, Screen.getPrimary().getVisualBounds().getHeight());
        cajaCompleta.setSpacing(40);
        cajaCompleta.setStyle("-fx-background-color: rgba(42,51,51,0.2);");
        cajaCompleta.setAlignment(Pos.CENTER);

        BotonOcultarBotones botonOcultarBotones = new BotonOcultarBotones();

        this.getChildren().addAll(inventarioLayout, cajaCompleta, botonOcultarBotones);
    }

}