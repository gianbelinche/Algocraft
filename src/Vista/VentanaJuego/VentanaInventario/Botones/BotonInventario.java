package Vista.VentanaJuego.VentanaInventario.Botones;

import Controlador.BotonesHandlers.BotonEntrarInventarioHandler;
import Controlador.BotonesHandlers.BotonInventarioHandler;
import Modelo.Almacenable;
import javafx.scene.control.Button;

public class BotonInventario extends Button {
    public BotonInventario(Almacenable materialSeleccionado, int x, int y){
        /*BotonInventarioHandler botonInventarioHandler = new BotonInventarioHandler(materialSeleccionado, x, y);
        this.setOnAction(botonInventarioHandler);*/
    }
}
