package Vista;

import Controlador.StartButtonHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class StartButton extends Button {

    public StartButton(Stage stage, StackPane pane){
        this.setText("START");
        StartButtonHandler startButtonHandler = new StartButtonHandler(stage);
        this.setOnAction(startButtonHandler);
    }

}
