package Vista;

import Controlador.BotonInventarioHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class BotonInventario extends Button{

        public BotonInventario(Stage stage, InventarioLayout pane){
            this.setText("Inventario");
            BotonInventarioHandler botonInventarioHandler = new BotonInventarioHandler(this, pane);
            this.setOnAction(botonInventarioHandler);
    }


}





