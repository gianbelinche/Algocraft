package Controlador.BotonesHandlers;

import Vista.Ventana;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonAyudaHandler implements EventHandler<ActionEvent> {

    private Ventana ventana;

    public BotonAyudaHandler(Ventana nuevaVentana){
        ventana = nuevaVentana;
    }

    @Override
    public void handle(ActionEvent event) {
        ventana.mostrarAyuda();
    }
}
