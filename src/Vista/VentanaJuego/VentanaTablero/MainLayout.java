package Vista.VentanaJuego.VentanaTablero;


import Controlador.*;
import Controlador.BotonesHandlers.BotonPicarTalarHandler;
import Modelo.Juego;
import Vista.Ventana;
import Vista.VentanaJuego.VentanaInventario.InventarioLayout;
import Vista.VentanaJuego.VentanaTablero.Botones.*;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class MainLayout extends Pane {

    public MainLayout(Stage mainStage, Juego juego, Ventana ventana) {

        //Creo botones de movimiento
        BotonMoverAbajo botonMoverAbajo = new BotonMoverAbajo(ventana,juego.obtenerJugador());
        BotonMoverDerecha botonMoverDerecha = new BotonMoverDerecha(ventana,juego.obtenerJugador());
        BotonMoverIzquierda botonMoverIzquierda = new BotonMoverIzquierda(ventana,juego.obtenerJugador());

        HBox botonesMovimientoAbajo = new HBox(botonMoverIzquierda, botonMoverAbajo, botonMoverDerecha);

        BotonMoverArriba botonMoverArriba = new BotonMoverArriba(ventana,juego.obtenerJugador());
        botonMoverArriba.setTranslateX(28); //Lo acomodo

        VBox botonesMovimientoCompleto = new VBox(botonMoverArriba, botonesMovimientoAbajo);
        botonesMovimientoCompleto.setSpacing(10);

        //Creo boton para picar/talar
        BotonPicarTalar botonPicarTalar = new BotonPicarTalar(ventana, juego.obtenerJugador());
        VBox contenedorBotones = new VBox(botonPicarTalar);
        contenedorBotones.setSpacing(20);

        //Creo boton inventario
        InventarioLayout inventarioLayout = new InventarioLayout((mainStage));
        BotonEntrarInventario botonEntrarInventario = new BotonEntrarInventario(inventarioLayout, contenedorBotones);
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

        BotonOcultarBotones botonOcultarBotones = new BotonOcultarBotones(cajaCompleta);
        //ExitButton botonSalir = new ExitButton(mainStage);

        this.getChildren().addAll(inventarioLayout, cajaCompleta, botonOcultarBotones);
    }

}