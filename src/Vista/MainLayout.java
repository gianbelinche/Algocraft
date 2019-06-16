package Vista;


import Controlador.SalirDeInventarioHandler;
import javafx.geometry.Pos;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.shape.Box;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class MainLayout extends Pane {

    public MainLayout(Stage mainStage) {
        //Creo botones de movimiento
        BotonMoverArriba botonMoverArriba = new BotonMoverArriba(mainStage);
        BotonMoverAbajo botonMoverAbajo = new BotonMoverAbajo(mainStage);
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
        cajaCompleta.setStyle("-fx-background-color: #000000;");
        cajaCompleta.setAlignment(Pos.CENTER);

        this.getChildren().addAll(inventarioLayout, cajaCompleta);
    }

}