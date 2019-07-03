package Controlador.BotonesHandlers;

import Modelo.Construccion.Receta;
import Vista.VentanaJuego.VentanaInventario.InventarioLayout;
import Vista.VentanaJuego.VentanaInventario.MesaCrafteo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonLimpiarMesaCrafteoHandler implements EventHandler<ActionEvent> {
    private Receta receta;
    private InventarioLayout inventarioLayout;
    private MesaCrafteo mesa;
    public BotonLimpiarMesaCrafteoHandler(Receta receta, MesaCrafteo mesa, InventarioLayout inventarioLayout){
        this.receta = receta;
        this.mesa = mesa;
        this.inventarioLayout = inventarioLayout;
    }
    @Override
    public void handle(ActionEvent event){
        receta.devolverAlInventario();
        mesa.vaciar();
        inventarioLayout.actualizarMateriales();
        inventarioLayout.actualizarHerramientas();
    }
}
