package Vista;


import Controlador.SalirDeInventarioHandler;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MainLayout extends Pane {

    public MainLayout(Stage mainStage) {

        //Cargo Imagen
        Image image = new Image("file:src/Vista/Imagenes/TableroPrueba.jpg");

        BackgroundImage backgroundImage = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(1.0, 1.0, true, true, false, false));
        //Adapto tamaño de imagen a tamaño de pantalla

        Background background = new Background(backgroundImage);
        InventarioLayout inventarioLayout = new InventarioLayout((mainStage));
        //Creo boton inventario

        VBox contenedorBotones = new VBox();
        BotonEntrarInventario botonEntrarInventario = new BotonEntrarInventario(inventarioLayout, contenedorBotones);
        //ExitButton botonSalir = new ExitButton(mainStage);
        contenedorBotones.getChildren().addAll(botonEntrarInventario);
        this.setOnKeyPressed(new SalirDeInventarioHandler(inventarioLayout));

        this.getChildren().addAll(inventarioLayout, contenedorBotones);
        this.setBackground(background);
    }

}
