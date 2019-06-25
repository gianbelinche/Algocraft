package Vista.VentanaJuego.VentanaInventario;

import Modelo.Construccion.Constructor;
import Modelo.Jugador;
import Vista.VentanaJuego.VentanaInventario.Botones.BotonInventarioHerramienta;
import Vista.VentanaJuego.VentanaInventario.Botones.BotonVacio;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;

public class InventarioHerramientas extends GridPane {

    public InventarioHerramientas(Constructor constructor, InventarioLayout inventarioLayout, Jugador jugador) {

        this.setPrefSize(inventarioLayout.getPrefWidth()*0.5, inventarioLayout.getPrefHeight()*0.5);
        this.setAlignment(Pos.CENTER);

        //Creo botones de herramientas
        BotonInventarioHerramienta botonHerramienta;

        botonHerramienta = new BotonInventarioHerramienta(new Image("file:src/Vista/Imagenes/BotonHachaMadera.png")
                , 1, constructor.crearHachaDeMadera(), jugador);
        this.add(botonHerramienta, 0, 0, 1, 1);

        botonHerramienta = new BotonInventarioHerramienta(new Image("file:src/Vista/Imagenes/BotonHachaPiedra.png")
                ,0,constructor.crearHachaDePiedra(), jugador);
        this.add(botonHerramienta, 1, 0, 1, 1);

        botonHerramienta = new BotonInventarioHerramienta(new Image("file:src/Vista/Imagenes/BotonHachaMetal.png")
                ,0,constructor.crearHachaDeMetal(),jugador);
        this.add(botonHerramienta, 2, 0, 1, 1);

        botonHerramienta = new BotonInventarioHerramienta(new Image("file:src/Vista/Imagenes/BotonPicoMadera.png")
                ,0,constructor.crearPicoDeMadera(),jugador);
        this.add(botonHerramienta, 3, 0, 1, 1);

        botonHerramienta = new BotonInventarioHerramienta(new Image("file:src/Vista/Imagenes/BotonPicoPiedra.png")
                ,0,constructor.crearPicoDePiedra(),jugador);
        this.add(botonHerramienta, 4, 0, 1, 1);

        botonHerramienta = new BotonInventarioHerramienta(new Image("file:src/Vista/Imagenes/BotonPicoMetal.png")
                ,0,constructor.crearPicoDeMetal(),jugador);
        this.add(botonHerramienta, 5, 0, 1, 1);

        botonHerramienta = new BotonInventarioHerramienta(new Image("file:src/Vista/Imagenes/BotonPicoFino.png")
                ,0,constructor.crearPicoDePiedraRefinada(),jugador);
        this.add(botonHerramienta, 6, 0, 1, 1);

        //Relleno con botones vacios
        BotonVacio botonVacio;
        for(int i=7; i<9; i++){
            botonVacio = new BotonVacio(new Image("file:src/Vista/Imagenes/BotonVacio.png"));
            this.add(botonVacio, i, 0, 1, 1);
        }
    }

}
