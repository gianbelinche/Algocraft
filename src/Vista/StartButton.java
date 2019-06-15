package Vista;

import Controlador.StartButtonHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class StartButton extends Button {

    public StartButton(Stage stage, TitleLayout pane){
        this.setText("START");
        StartButtonHandler startButtonHandler = new StartButtonHandler(stage);
        this.setOnAction(startButtonHandler);
    }

}
