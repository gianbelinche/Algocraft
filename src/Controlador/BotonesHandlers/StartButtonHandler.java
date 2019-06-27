package Controlador.BotonesHandlers;

import Vista.Ventana;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class StartButtonHandler implements EventHandler<ActionEvent> {

    Stage escenario;
    Ventana ventana;

    public StartButtonHandler(Stage nuevoEscenario, Ventana nuevaVentana){
       escenario = nuevoEscenario;
       ventana = nuevaVentana;
    }

    public void handle(ActionEvent event){
        ventana.mainStart(escenario);
    }

}
