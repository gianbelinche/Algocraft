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
        if ((contador%2) == 0) {
            button.setText("Mostrar Botones");
            caja.setVisible(false);
        }
        else {
            button.setText("Ocultar Botones");
            caja.setVisible(true);
        }
        contador += 1;
    }

}
