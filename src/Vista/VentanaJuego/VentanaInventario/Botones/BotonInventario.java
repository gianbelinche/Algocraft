package Vista.VentanaJuego.VentanaInventario.Botones;

import Controlador.BotonesHandlers.BotonInventarioHandler;
import Modelo.Materiales.Material;
import Vista.VentanaJuego.VentanaInventario.MaterialSeleccionado;
import javafx.scene.control.Button;

public class BotonInventario extends Button {
    BotonInventarioHandler botonInventarioHandler;

    public BotonInventario(MaterialSeleccionado materialSeleccionado){
        botonInventarioHandler = new BotonInventarioHandler(materialSeleccionado);
        this.setOnAction(botonInventarioHandler);
    }
    public void setMaterial(Material miMaterial){
        botonInventarioHandler.setMaterial(miMaterial);
    }
}
