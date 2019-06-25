package Vista.VentanaJuego.VentanaInventario;

import Modelo.Construccion.Constructor;
import Vista.VentanaJuego.VentanaInventario.Botones.BotonInventarioHerramienta;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;

public class InventarioHerramientas extends GridPane {

    public InventarioHerramientas(Constructor constructor, InventarioLayout inventarioLayout) {
        BotonInventarioHerramienta botonHerramienta;

        this.setPrefSize(inventarioLayout.getPrefWidth()*0.5, inventarioLayout.getPrefHeight()*0.5);
        this.setAlignment(Pos.CENTER);

        //Creo botones de herramientas
        botonHerramienta = new BotonInventarioHerramienta(constructor.crearHachaDeMadera(), new Image("file:src/Vista/Imagenes/BotonHachaMadera.png"));
        this.add(botonHerramienta, 0, 0, 1, 1);
        botonHerramienta = new BotonInventarioHerramienta(constructor.crearHachaDePiedra(), new Image("file:src/Vista/Imagenes/BotonHachaPiedra.png"));
        this.add(botonHerramienta, 1, 0, 1, 1);
        botonHerramienta = new BotonInventarioHerramienta(constructor.crearHachaDeMetal(), new Image("file:src/Vista/Imagenes/BotonHachaMetal.png"));
        this.add(botonHerramienta, 2, 0, 1, 1);
        botonHerramienta = new BotonInventarioHerramienta(constructor.crearPicoDeMadera(), new Image("file:src/Vista/Imagenes/BotonPicoMadera.png"));
        this.add(botonHerramienta, 3, 0, 1, 1);
        botonHerramienta = new BotonInventarioHerramienta(constructor.crearPicoDePiedra(), new Image("file:src/Vista/Imagenes/BotonPicoPiedra.png"));
        this.add(botonHerramienta, 4, 0, 1, 1);
        botonHerramienta = new BotonInventarioHerramienta(constructor.crearPicoDeMetal(), new Image("file:src/Vista/Imagenes/BotonPicoMetal.png"));
        this.add(botonHerramienta, 5, 0, 1, 1);
        botonHerramienta = new BotonInventarioHerramienta(constructor.crearPicoDePiedraRefinada(), new Image("file:src/Vista/Imagenes/BotonPicoFino.png"));
        this.add(botonHerramienta, 6, 0, 1, 1);
        for(int i=7; i<9; i++){
            botonHerramienta = new BotonInventarioHerramienta(null, new Image("file:src/Vista/Imagenes/BotonVacio.png"));
            this.add(botonHerramienta, i, 0, 1, 1);
        }
    }

}
