package Controlador;


import Vista.InventarioLayout;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;

public class BotonEntrarInventarioHandler implements EventHandler<ActionEvent> {

        private InventarioLayout inventario;
        private VBox botones;

        public BotonEntrarInventarioHandler(VBox contenedorBotones, InventarioLayout unInventario){
            this.inventario = unInventario;
            this.botones = contenedorBotones;
        }
        @Override
        public void handle(ActionEvent event){

            inventario.setVisible(true);
            //botones.setVisible(false);
        }


}
