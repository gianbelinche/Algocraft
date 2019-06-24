package Controlador.BotonesHandlers;


import Modelo.Materiales.Material;
import Vista.VentanaJuego.VentanaInventario.MaterialSeleccionado;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonInventarioHandler implements EventHandler<ActionEvent> {
    MaterialSeleccionado materialSeleccionado;
    Material miMaterial;

    public BotonInventarioHandler(MaterialSeleccionado materialSelec) {
        materialSeleccionado = materialSelec;
    }

    public void setMaterial(Material material){
        miMaterial = material;
    }
    @Override
    public void handle(ActionEvent event) {
        materialSeleccionado.seleccionarMaterial(miMaterial);
    }
}
