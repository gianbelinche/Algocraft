package Controlador.BotonesHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class BotonSalirHandler implements EventHandler<ActionEvent> {

    Stage stage;

    public BotonSalirHandler(Stage stage){
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent event) {
        stage.close();
    }

}
