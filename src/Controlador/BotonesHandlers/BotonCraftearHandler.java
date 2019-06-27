package Controlador.BotonesHandlers;

import Modelo.Inventario.Almacenable;
import Modelo.Construccion.Receta;
import Modelo.Construccion.Recetario;
import Modelo.Herramientas.Herramienta;
import Jugador.Jugador;
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
            devolverAlmacenables(receta,jugador);
        } else {
            jugador.guardarEnInventario(herramienta);
        }

        receta.vaciar();
        mesa.vaciar();
        inventarioLayout.actualizarMateriales();
        inventarioLayout.actualizarHerramientas();
    }

    private void devolverAlmacenables(Receta receta, Jugador jugador){
        for(int i =0;i<3;i++){
            for(int j=0;j<3;j++){
                Almacenable almacenable = receta.enPosicion(i,j);
                if (almacenable != null){
                    jugador.guardarEnInventario(almacenable);
                }
            }
        }
    }
}
