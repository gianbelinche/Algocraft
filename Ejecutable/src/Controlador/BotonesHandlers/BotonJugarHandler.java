package Controlador.BotonesHandlers;

import Vista.Ventana;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class BotonJugarHandler implements EventHandler<ActionEvent> {

    Stage escenario;
    Ventana ventana;

    public BotonJugarHandler(Stage nuevoEscenario, Ventana nuevaVentana){
       escenario = nuevoEscenario;
       ventana = nuevaVentana;
    }

    public void handle(ActionEvent event){
        ventana.mainStart(escenario);
    }

}
