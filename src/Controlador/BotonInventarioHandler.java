package Controlador;

import Vista.InventarioLayout;
import Vista.Ventana;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class BotonInventarioHandler implements EventHandler<ActionEvent> {
        StackPane inventario;
        public BotonInventarioHandler(StackPane unInventario){
            this.inventario = unInventario;
        }

        public void handle(ActionEvent event){
            inventario.setVisible(true);
        }


}
