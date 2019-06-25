package Vista.VentanaJuego.VentanaInventario;

import Vista.VentanaJuego.VentanaInventario.Botones.BotonInventarioMaterial;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;

public class InventarioMateriales extends GridPane {

    public InventarioMateriales(MaterialSeleccionado materialSeleccionado, InventarioLayout inventarioLayout) {
        BotonInventarioMaterial botonInventarioMaterial;

        this.setPrefSize(inventarioLayout.getPrefWidth()*0.5, inventarioLayout.getPrefHeight()*0.5);
        this.setAlignment(Pos.BOTTOM_CENTER);

        for(int i=0; i < 3; i++){
            for(int j=0; j<9; j++){
                botonInventarioMaterial = new BotonInventarioMaterial(materialSeleccionado, new Image("file:src/Vista/Imagenes/BotonVacio.png"));
                this.add(botonInventarioMaterial, j, i, 1, 1);
            }
        }
        botonInventarioMaterial = new BotonInventarioMaterial(materialSeleccionado, new Image("file:src/Vista/Imagenes/BotonMadera.png"));
        this.add(botonInventarioMaterial, 0, 0, 1, 1);
        botonInventarioMaterial = new BotonInventarioMaterial(materialSeleccionado, new Image("file:src/Vista/Imagenes/BotonPiedra.png"));
        this.add(botonInventarioMaterial, 1, 0, 1, 1);
        botonInventarioMaterial = new BotonInventarioMaterial(materialSeleccionado, new Image("file:src/Vista/Imagenes/BotonMetal.png"));
        this.add(botonInventarioMaterial, 2, 0, 1, 1);
        botonInventarioMaterial = new BotonInventarioMaterial(materialSeleccionado, new Image("file:src/Vista/Imagenes/BotonDiamante.png"));
        this.add(botonInventarioMaterial, 3, 0, 1, 1);
    }

}
