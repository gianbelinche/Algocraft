package Vista.VentanaPrincipal;

import Controlador.BotonesHandlers.ExitButtonHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class ExitButton extends Button {

    public ExitButton(Stage stage){
        this.setText("EXIT");
        ExitButtonHandler exitButtonHandler = new ExitButtonHandler(stage,this);
        this.setOnAction(exitButtonHandler);
        //Seteo tamaño a 5% de pantalla
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        this.setPrefWidth(primaryScreenBounds.getWidth()*0.1);
        this.setPrefHeight(primaryScreenBounds.getHeight()*0.05);
    }

}
