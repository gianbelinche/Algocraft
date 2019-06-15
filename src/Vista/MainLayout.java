package Vista;

import javafx.geometry.Pos;
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

        BotonInventario botonInventario = new BotonInventario(mainStage, inventarioLayout);
       // botonInventario.setTranslateX(10);
        //botonInventario.setTranslateY(10);
        //botonInventario.setTranslateZ(10);
        botonInventario.setAlignment(Pos.BOTTOM_LEFT);


        this.getChildren().addAll(inventarioLayout, botonInventario);
        this.setBackground(background);
    }

}
