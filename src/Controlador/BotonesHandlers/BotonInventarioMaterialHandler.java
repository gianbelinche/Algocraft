package Controlador.BotonesHandlers;


import Modelo.Materiales.Material;
import Vista.VentanaJuego.VentanaInventario.MaterialSeleccionado;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.BackgroundImage;

public class BotonInventarioMaterialHandler implements EventHandler<ActionEvent> {
    MaterialSeleccionado materialSeleccionado;
    Material miMaterial;
    BackgroundImage backgroundImage;

    public BotonInventarioMaterialHandler(MaterialSeleccionado materialSelec, BackgroundImage backgroundImage) {
        this.backgroundImage = backgroundImage;
        materialSeleccionado = materialSelec;
    }

    public void setMaterial(Material material){
        miMaterial = material;
    }
    @Override
    public void handle(ActionEvent event) {

        materialSeleccionado.seleccionarMaterial(miMaterial);
        materialSeleccionado.definirFondo(backgroundImage);
    }
}
