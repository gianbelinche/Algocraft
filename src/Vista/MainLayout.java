package Vista;

import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MainLayout extends StackPane {

    public MainLayout(Stage mainStage) {

        //Cargo Imagen
        Image image = new Image("file:src/Vista/Imagenes/TableroPrueba.jpg");

        BackgroundImage backgroundImage = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(1.0, 1.0, true, true, false, false));
        //Adapto tamaño de imagen a tamaño de pantalla

        Background background = new Background(backgroundImage);

        this.setBackground(background);
    }

}
