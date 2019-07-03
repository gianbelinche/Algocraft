package Vista.VentanaJuego.VentanaTablero;


import Modelo.Juego;
import Vista.Ventana;
import Vista.VentanaJuego.VentanaInventario.InventarioLayout;
import Vista.VentanaJuego.VentanaTablero.Botones.*;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class MainLayout extends Pane {

    public MainLayout(Stage mainStage, Juego juego, Ventana ventana, InventarioLayout inventarioLayout, BotonHerramientaEquipada botonHerramientaEquipada) {

        //Creo botones de movimiento
        BotonMoverAbajo botonMoverAbajo = new BotonMoverAbajo(ventana,juego.obtenerJugador());
        BotonMoverDerecha botonMoverDerecha = new BotonMoverDerecha(ventana,juego.obtenerJugador());
        BotonMoverIzquierda botonMoverIzquierda = new BotonMoverIzquierda(ventana,juego.obtenerJugador());

        HBox botonesMovimientoAbajo = new HBox(botonMoverIzquierda, botonMoverAbajo, botonMoverDerecha);

        BotonMoverArriba botonMoverArriba = new BotonMoverArriba(ventana,juego.obtenerJugador());

        VBox botonesMovimientoCompleto = new VBox(botonMoverArriba, botonesMovimientoAbajo);
        botonesMovimientoCompleto.setSpacing(10);
        botonesMovimientoCompleto.setAlignment(Pos.CENTER);

        //Creo boton para picar/talar
        BotonPicarTalar botonPicarTalar = new BotonPicarTalar(ventana, juego.obtenerJugador());

        //Creo boton ayuda
        BotonAyuda botonAyuda = new BotonAyuda(ventana);

        //Creo boton inventario
        BotonEntrarInventario botonEntrarInventario = new BotonEntrarInventario(inventarioLayout, ventana);

        //Creo boton reiniciar
        BotonReiniciarJuego botonReiniciarJuego = new BotonReiniciarJuego(ventana, mainStage);

        //Creo contenedor de botones principal
        VBox contenedorBotones = new VBox(botonPicarTalar, botonEntrarInventario, botonAyuda,botonReiniciarJuego);
        contenedorBotones.setSpacing(20);
        contenedorBotones.setAlignment(Pos.CENTER);

        //Columna de Botones
        VBox columnaBotones = new VBox(botonHerramientaEquipada, botonesMovimientoCompleto, contenedorBotones);
        columnaBotones.setSpacing(100);
        columnaBotones.setAlignment(Pos.CENTER);

        //Caja Completa y Centrada
        HBox cajaCompleta = new HBox(columnaBotones);
        cajaCompleta.setPrefSize(150, Screen.getPrimary().getVisualBounds().getHeight());
        cajaCompleta.setSpacing(40);
        cajaCompleta.setStyle("-fx-background-color: rgba(42,51,51,0.2);");
        cajaCompleta.setAlignment(Pos.CENTER);

        BotonOcultarBotones botonOcultarBotones = new BotonOcultarBotones(cajaCompleta);

        this.getChildren().addAll(cajaCompleta, botonOcultarBotones);
    }

}