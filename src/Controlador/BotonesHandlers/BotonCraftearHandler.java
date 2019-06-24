package Controlador.BotonesHandlers;

import Modelo.Construccion.Receta;
import Modelo.Construccion.Recetario;
import Modelo.Herramientas.Herramienta;
import Modelo.Inventario;
import Modelo.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class BotonCraftearHandler implements EventHandler<javafx.event.ActionEvent> {
    Receta receta;
    Jugador jugador;

    public BotonCraftearHandler(Receta receta, Jugador jugador){
        this.receta = receta;
        this.jugador = jugador;

    }

    public void handle(ActionEvent event){
        Recetario recetario = new Recetario();
        Herramienta herramienta = recetario.craftear(receta);
        jugador.guardarEnInventario(herramienta);
    }
}
