package Vista.VentanaJuego.VentanaInventario.Botones;

import Controlador.BotonesHandlers.BotonInventarioMaterialHandler;
import Modelo.ElementosJugador.Jugador;
import Modelo.Materiales.Material;
import Vista.VentanaJuego.VentanaInventario.MaterialSeleccionado;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class BotonInventarioMaterial extends Button {

    private int cantidad;
    private BotonInventarioMaterialHandler botonInventarioMaterialHandler;
    private Jugador jugador;
    private Material material;

    public BotonInventarioMaterial(MaterialSeleccionado materialSeleccionado, Image imagen, Material miMaterial, Jugador unJugador){

        BackgroundImage backgroundImage = new BackgroundImage(imagen,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(1.0, 1.0, true, true, false, false));

        this.setBackground(new Background(backgroundImage));

        this.botonInventarioMaterialHandler = new BotonInventarioMaterialHandler(materialSeleccionado,backgroundImage);
        this.setPrefSize(56,56);
        this.setOnAction(botonInventarioMaterialHandler);

        this.cantidad = 0;
        this.setText(Integer.toString(cantidad));
        this.setStyle("-fx-text-fill: rgb(252,246,255)");
        this.setAlignment(Pos.BOTTOM_RIGHT);

        botonInventarioMaterialHandler.setMaterial(miMaterial);
        this.material = miMaterial;
        this.jugador = unJugador;
    }

    public void actualizarCantidad(){
        this.cantidad = jugador.obtenerCantidadDeInventario(material);
        this.setText(Integer.toString(cantidad));
    }
}
