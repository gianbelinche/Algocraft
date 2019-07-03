package Controlador.BotonesHandlers;

import Modelo.Herramientas.Herramienta;
import Modelo.ElementosJugador.Jugador;
import Vista.VentanaJuego.VentanaInventario.InventarioLayout;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonInventarioHerramientaHandler implements EventHandler<ActionEvent> {

    private InventarioLayout inventarioLayout;
    private Herramienta herramienta;
    private Jugador jugador;

    public BotonInventarioHerramientaHandler(Herramienta miHerramienta, Jugador unJugador, InventarioLayout inventarioLayout) {
        jugador = unJugador;
        herramienta = miHerramienta;
        this.inventarioLayout = inventarioLayout;
    }

    @Override
    public void handle(ActionEvent event) {
        jugador.equipar(herramienta);
        inventarioLayout.actualizarHerramientas();
    }
}
