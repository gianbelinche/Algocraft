package Controlador.BotonesHandlers;

import Modelo.Jugador;
import Modelo.Almacenable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonInventarioHandler implements EventHandler<ActionEvent> {
    Jugador jugador;
    Almacenable materialSeleccionado;
    int x;
    int y;

    public BotonInventarioHandler(Almacenable material, int x_pasado, int y_pasado) {
        materialSeleccionado = material;
        x = x_pasado;
        y = y_pasado;
    }

    @Override
    public void handle(ActionEvent event) {
        //materialSeleccionado = jugador.obtenerDeInventario(x,y);

    }
}
