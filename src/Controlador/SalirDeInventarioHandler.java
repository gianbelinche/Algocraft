package Controlador;

import Vista.VentanaJuego.VentanaInventario.InventarioLayout;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class SalirDeInventarioHandler implements EventHandler<KeyEvent> {

    private InventarioLayout inventario;

    public SalirDeInventarioHandler(InventarioLayout inventarioLayout){
        this.inventario = inventarioLayout;
    }
    @Override
    public void handle(KeyEvent event) {

        if (event.getCode() == KeyCode.ESCAPE) {
            inventario.setVisible(false);
        }
    }
}
