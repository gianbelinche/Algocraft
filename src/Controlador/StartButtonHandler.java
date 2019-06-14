package Controlador;

import Vista.VentanaInventario;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class StartButtonHandler implements EventHandler<ActionEvent> {
    Stage stage;
    VentanaInventario ventana = new VentanaInventario();
    public StartButtonHandler(Stage stage){
        this.stage = stage;
    }
    public void handle(ActionEvent event){
        this.ventana.start(stage);
    }
}
