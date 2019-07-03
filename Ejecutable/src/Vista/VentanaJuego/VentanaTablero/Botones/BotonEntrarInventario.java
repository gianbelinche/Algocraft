package Vista.VentanaJuego.VentanaTablero.Botones;

import Controlador.BotonesHandlers.BotonEntrarSalirInventarioHandler;
import Vista.Ventana;
import Vista.VentanaJuego.VentanaInventario.InventarioLayout;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;


public class BotonEntrarInventario extends Button{

        public BotonEntrarInventario(InventarioLayout pane, Ventana ventana){
            this.setText("Inventario");
            BotonEntrarSalirInventarioHandler botonEntrarSalirInventarioHandler = new BotonEntrarSalirInventarioHandler(pane, ventana);
            this.setOnAction(botonEntrarSalirInventarioHandler);
    }


}





