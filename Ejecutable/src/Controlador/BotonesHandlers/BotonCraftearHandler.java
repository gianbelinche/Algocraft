package Controlador.BotonesHandlers;

import Modelo.Construccion.Receta;
import Modelo.Construccion.Recetario;
import Modelo.Herramientas.Herramienta;
import Modelo.ElementosJugador.Jugador;
import Vista.VentanaJuego.VentanaInventario.InventarioLayout;
import Vista.VentanaJuego.VentanaInventario.MesaCrafteo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class BotonCraftearHandler implements EventHandler<javafx.event.ActionEvent> {
    Receta receta;
    Jugador jugador;
    InventarioLayout inventarioLayout;
    MesaCrafteo mesa;

    public BotonCraftearHandler(Receta receta, Jugador jugador, InventarioLayout inventarioLayout, MesaCrafteo mesa){
        this.receta = receta;
        this.jugador = jugador;
        this.inventarioLayout = inventarioLayout;
        this.mesa = mesa;

    }


    public void handle(ActionEvent event){
        Recetario recetario =  new Recetario();
        Herramienta herramienta = recetario.craftear(receta);

        if (herramienta == null) {
            receta.devolverAlInventario();
        } else {
            jugador.guardarEnInventario(herramienta);
        }

        mesa.vaciar();
        inventarioLayout.actualizarMateriales();
        inventarioLayout.actualizarHerramientas();
    }
}
