package Vista;

import Controlador.StartButtonHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class StartButton extends Button {

    public StartButton(Stage stage){
        StartButtonHandler startButtonHandler = new StartButtonHandler(stage);
        this.setOnAction(startButtonHandler);

        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

        Image image = new Image("file:src/Vista/Imagenes/BotonPlay.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(primaryScreenBounds.getWidth()*0.15);
        imageView.setFitHeight(primaryScreenBounds.getHeight()*0.08);

        this.setGraphic(imageView);

        //Seteo tamaño a 5% de pantalla

    }

}
