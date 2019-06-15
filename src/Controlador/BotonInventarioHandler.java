package Controlador;


import Vista.BotonInventario;
import Vista.InventarioLayout;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.StackPane;

public class BotonInventarioHandler implements EventHandler<ActionEvent> {

        private InventarioLayout inventario;
        private BotonInventario botonInventario;

        public BotonInventarioHandler(BotonInventario boton, InventarioLayout unInventario){
            this.inventario = unInventario;
            this.botonInventario = boton;
        }
        @Override
        public void handle(ActionEvent event){

            inventario.setVisible(true);
            botonInventario.setVisible(false);
        }


}
