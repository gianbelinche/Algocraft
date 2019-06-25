package Controlador.BotonesHandlers;


import Vista.VentanaJuego.VentanaInventario.InventarioLayout;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;

public class BotonEntrarSalirInventarioHandler implements EventHandler<ActionEvent> {

        private InventarioLayout inventario;

        public BotonEntrarSalirInventarioHandler(InventarioLayout unInventario){
            this.inventario = unInventario;
        }
        @Override
        public void handle(ActionEvent event){
            inventario.setVisible(!inventario.isVisible());
            inventario.actualizarHerramientas();
            inventario.actualizarMateriales();
        }


}
