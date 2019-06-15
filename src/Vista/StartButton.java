package Vista;

import Controlador.StartButtonHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class StartButton extends Button {

    public StartButton(Stage stage){
        this.setText("START");
        StartButtonHandler startButtonHandler = new StartButtonHandler(stage);
        this.setOnAction(startButtonHandler);
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        this.setPrefWidth(primaryScreenBounds.getWidth()*0.05);
        this.setPrefHeight(primaryScreenBounds.getHeight()*0.05);
    }

}
