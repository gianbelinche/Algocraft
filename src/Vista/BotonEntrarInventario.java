package Vista;

import Controlador.BotonEntrarInventarioHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;


public class BotonEntrarInventario extends Button{

        public BotonEntrarInventario(InventarioLayout pane, VBox botones){
            this.setText("Inventario");
            BotonEntrarInventarioHandler botonEntrarInventarioHandler = new BotonEntrarInventarioHandler(botones, pane);
            this.setOnAction(botonEntrarInventarioHandler);
    }


}




