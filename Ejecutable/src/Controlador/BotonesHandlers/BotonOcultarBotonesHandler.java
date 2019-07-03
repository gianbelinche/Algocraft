package Controlador.BotonesHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class BotonOcultarBotonesHandler implements EventHandler<ActionEvent> {

    Button button;
    HBox caja;
    private int contador = 0;

    public BotonOcultarBotonesHandler(Button button, HBox cajaCompleta){
        this.button = button;
        this.caja = cajaCompleta;
    }

    @Override
    public void handle(ActionEvent event) {
        caja.setVisible(!caja.isVisible());
        if (caja.isVisible()) {
            button.setText("Ocultar Botones");
        }
        else {
            button.setText("Mostrar Botones");
        }
    }

}
