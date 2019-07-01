package Vista.VentanaJuego.VentanaInventario.Botones;

import Controlador.BotonesHandlers.BotonLimpiarMesaCrafteoHandler;
import Modelo.Construccion.Receta;
import Vista.VentanaJuego.VentanaInventario.InventarioLayout;
import Vista.VentanaJuego.VentanaInventario.MesaCrafteo;
import javafx.scene.control.Button;


public class BotonLimpiarMesaCrafteo extends Button {

    public BotonLimpiarMesaCrafteo(Receta receta, MesaCrafteo mesa, InventarioLayout inventarioLayout){
        this.setText("Limpiar mesa");
        this.setOnAction(new BotonLimpiarMesaCrafteoHandler(receta, mesa, inventarioLayout));
    }
}
