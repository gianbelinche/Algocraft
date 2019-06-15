package Vista;

import Controlador.BotonInventarioHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class BotonInventario extends Button{

        public BotonInventario(Stage stage, StackPane pane){
            this.setText("Inventario");
            BotonInventarioHandler botonInventarioHandler = new BotonInventarioHandler(pane);
            this.setOnAction(botonInventarioHandler);
    }


}





