package Controlador.BotonesHandlers;

import Vista.Ventana;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class BotonReiniciarJuegoHandler implements EventHandler<ActionEvent> {

    private Stage stage;
    private Ventana ventana;

    public BotonReiniciarJuegoHandler(Ventana ventana, Stage mainStage) {
        this.ventana = ventana;
        this.stage = mainStage;
    }

    @Override
    public void handle(ActionEvent event) {
        ventana.mainStart(stage);
    }

}
