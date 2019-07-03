package Vista.VentanaJuego.VentanaInventario;

import Modelo.ElementosJugador.Jugador;
import Modelo.Materiales.Diamante;
import Modelo.Materiales.Madera;
import Modelo.Materiales.Metal;
import Modelo.Materiales.Piedra;
import Vista.VentanaJuego.VentanaInventario.Botones.BotonInventarioMaterial;
import Vista.VentanaJuego.VentanaInventario.Botones.BotonVacio;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;

public class InventarioMateriales extends GridPane {

    public InventarioMateriales(MaterialSeleccionado materialSeleccionado, InventarioLayout inventarioLayout, Jugador jugador) {

        this.setPrefSize(inventarioLayout.getPrefWidth()*0.5, inventarioLayout.getPrefHeight()*0.45);
        this.setTranslateY(-1*inventarioLayout.getPrefHeight()*0.25);//-90
        this.setAlignment(Pos.CENTER);
        BotonVacio botonVacio;
        for(int i=0; i < 3; i++){
            for(int j=0; j<9; j++){
                botonVacio = new BotonVacio(new Image("file:src/Vista/Imagenes/BotonVacio.png"));
                this.add(botonVacio, j, i, 1, 1);
            }
        }
        BotonInventarioMaterial botonInventarioMaterial;
        botonInventarioMaterial = new BotonInventarioMaterial(materialSeleccionado, new Image("file:src/Vista/Imagenes/BotonMadera.png")
                , new Madera(), jugador);
        this.add(botonInventarioMaterial, 0, 0, 1, 1);

        botonInventarioMaterial = new BotonInventarioMaterial(materialSeleccionado, new Image("file:src/Vista/Imagenes/BotonPiedra.png")
                , new Piedra(), jugador);
        this.add(botonInventarioMaterial, 1, 0, 1, 1);

        botonInventarioMaterial = new BotonInventarioMaterial(materialSeleccionado, new Image("file:src/Vista/Imagenes/BotonMetal.png")
                , new Metal(), jugador);
        this.add(botonInventarioMaterial, 2, 0, 1, 1);

        botonInventarioMaterial = new BotonInventarioMaterial(materialSeleccionado, new Image("file:src/Vista/Imagenes/BotonDiamante.png")
                , new Diamante(), jugador);
        this.add(botonInventarioMaterial, 3, 0, 1, 1);
    }

    public void actualizar(){
        for (Node child : this.getChildren()){
            if(child instanceof BotonInventarioMaterial) {
                ((BotonInventarioMaterial) child).actualizarCantidad();
            }
        }
    }
}
