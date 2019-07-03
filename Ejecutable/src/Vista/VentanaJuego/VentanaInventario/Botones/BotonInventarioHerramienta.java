package Vista.VentanaJuego.VentanaInventario.Botones;

import Controlador.BotonesHandlers.BotonInventarioHerramientaHandler;
import Modelo.Herramientas.Herramienta;
import Modelo.ElementosJugador.Jugador;
import Vista.VentanaJuego.VentanaInventario.InventarioLayout;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class BotonInventarioHerramienta extends Button {

    private BotonInventarioHerramientaHandler botonInventarioHerramientaHandler;
    private Herramienta miHerramienta;
    private int cantidad;
    private Jugador jugador;

    public BotonInventarioHerramienta(Image imagen, Herramienta unaHerramienta, Jugador unJugador, InventarioLayout inventarioLayout){

        this.miHerramienta = unaHerramienta;
        this.jugador = unJugador;

        BackgroundImage backgroundImage = new BackgroundImage(imagen,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(1.0, 1.0, true, true, false, false));
        this.setBackground(new Background(backgroundImage));

        botonInventarioHerramientaHandler = new BotonInventarioHerramientaHandler(miHerramienta, jugador, inventarioLayout);
        this.setOnAction(botonInventarioHerramientaHandler);

        this.setPrefSize(56,56);

        cantidad = 0;

        this.setText(Integer.toString(cantidad));
        this.setStyle("-fx-text-fill: rgb(252,246,255)");
        this.setAlignment(Pos.BOTTOM_RIGHT);
    }

    public void actualizarCantidad(){
        this.cantidad = jugador.obtenerCantidadDeInventario(miHerramienta);
        this.setText(Integer.toString(cantidad));
    }
}
