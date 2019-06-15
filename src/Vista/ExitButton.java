package Vista;

import Controlador.ExitButtonHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ExitButton extends Button {

    public ExitButton(Stage stage){
        this.setText("EXIT");
        ExitButtonHandler exitButtonHandler = new ExitButtonHandler(stage,this);
        this.setOnAction(exitButtonHandler);
    }

}
