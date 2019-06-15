package Controlador;

import Vista.Ventana;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class StartButtonHandler implements EventHandler<ActionEvent> {

    Stage stage;
    Ventana ventana = new Ventana();

    public StartButtonHandler(Stage stage){
        this.stage = stage;
    }

    public void handle(ActionEvent event){
        this.ventana.mainStart(stage);
    }

}
