package Controlador.BotonesHandlers;


import Vista.Ventana;
import Vista.VentanaJuego.VentanaInventario.InventarioLayout;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonEntrarSalirInventarioHandler implements EventHandler<ActionEvent> {

    private Ventana ventana;
    private InventarioLayout inventario;

        public BotonEntrarSalirInventarioHandler(InventarioLayout unInventario, Ventana ventana){
            this.inventario = unInventario;
            this.ventana = ventana;
        }

        @Override
        public void handle(ActionEvent event){
            inventario.setVisible(!inventario.isVisible());
            inventario.actualizarHerramientas();
            inventario.actualizarMateriales();
            ventana.actualizarImagen();
        }


}
