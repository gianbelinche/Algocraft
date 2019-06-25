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
        botonHerramienta = new BotonInventarioHerramienta(new Image("file:src/Vista/Imagenes/BotonHachaMadera.png"));
        botonHerramienta.setCantidadYHerramienta(1,constructor.crearHachaDeMadera());
        this.add(botonHerramienta, 0, 0, 1, 1);

        botonHerramienta = new BotonInventarioHerramienta(new Image("file:src/Vista/Imagenes/BotonHachaPiedra.png"));
        botonHerramienta.setCantidadYHerramienta(0,constructor.crearHachaDePiedra());
        this.add(botonHerramienta, 1, 0, 1, 1);

        botonHerramienta = new BotonInventarioHerramienta(new Image("file:src/Vista/Imagenes/BotonHachaMetal.png"));
        botonHerramienta.setCantidadYHerramienta(0,constructor.crearHachaDeMetal());
        this.add(botonHerramienta, 2, 0, 1, 1);

        botonHerramienta = new BotonInventarioHerramienta(new Image("file:src/Vista/Imagenes/BotonPicoMadera.png"));
        botonHerramienta.setCantidadYHerramienta(0,constructor.crearPicoDeMadera());
        this.add(botonHerramienta, 3, 0, 1, 1);

        botonHerramienta = new BotonInventarioHerramienta(new Image("file:src/Vista/Imagenes/BotonPicoPiedra.png"));
        botonHerramienta.setCantidadYHerramienta(0,constructor.crearPicoDePiedra());
        this.add(botonHerramienta, 4, 0, 1, 1);

        botonHerramienta = new BotonInventarioHerramienta(new Image("file:src/Vista/Imagenes/BotonPicoMetal.png"));
        botonHerramienta.setCantidadYHerramienta(0,constructor.crearPicoDeMetal());
        this.add(botonHerramienta, 5, 0, 1, 1);

        botonHerramienta = new BotonInventarioHerramienta(new Image("file:src/Vista/Imagenes/BotonPicoFino.png"));
        botonHerramienta.setCantidadYHerramienta(0,constructor.crearPicoDePiedraRefinada());
        this.add(botonHerramienta, 6, 0, 1, 1);

        for(int i=7; i<9; i++){
            botonHerramienta = new BotonInventarioHerramienta(new Image("file:src/Vista/Imagenes/BotonVacio.png"));
            this.add(botonHerramienta, i, 0, 1, 1);
        }
    }

}
