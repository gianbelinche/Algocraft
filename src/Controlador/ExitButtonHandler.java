package Controlador;

import Vista.ExitButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ExitButtonHandler implements EventHandler<ActionEvent> {

    Stage stage;
    Button button;

    public ExitButtonHandler(Stage stage,Button button){
        this.stage = stage;
        this.button = button;
    }

    private int contador = 0;

    @Override
    public void handle(ActionEvent event) {
        if (contador == 0){
            button.setText("Don't Do It");
        }
        if (contador == 1){
            button.setText("Please Don't");
        }

        if (contador == 2){
            button.setText("I Have A Family");
        }
        if (contador > 2){
            stage.close();
        }
        contador += 1;
    }

}
