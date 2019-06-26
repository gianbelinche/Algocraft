package Controlador.BotonesHandlers;

import Modelo.Herramientas.Herramienta;
import Modelo.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonInventarioHerramientaHandler implements EventHandler<ActionEvent> {

    private Herramienta herramienta;
    private Jugador jugador;

    public BotonInventarioHerramientaHandler(Herramienta miHerramienta, Jugador unJugador) {
        jugador = unJugador;
        herramienta = miHerramienta;
    }

    @Override
    public void handle(ActionEvent event) {
        jugador.equipar(herramienta);
    }
}
