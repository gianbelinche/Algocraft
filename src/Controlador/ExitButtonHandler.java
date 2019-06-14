package Controlador;

import Vista.ExitButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class ExitButtonHandler implements EventHandler<ActionEvent> {
    Stage stage;
    public ExitButtonHandler(Stage stage){
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent event) {
        stage.close();
    }
}
