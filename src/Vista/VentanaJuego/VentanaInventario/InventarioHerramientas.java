package Vista.VentanaJuego.VentanaInventario;

import Modelo.Construccion.Constructor;
import Modelo.ElementosJugador.Jugador;
import Vista.VentanaJuego.VentanaInventario.Botones.BotonInventarioHerramienta;
import Vista.VentanaJuego.VentanaInventario.Botones.BotonVacio;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;

public class InventarioHerramientas extends GridPane {

    public InventarioHerramientas(Constructor constructor, InventarioLayout inventarioLayout, Jugador jugador) {

        this.setPrefSize(inventarioLayout.getPrefWidth()*0.5, inventarioLayout.getPrefHeight()*0.20);
        this.setAlignment(Pos.CENTER);

        //Creo botones de herramientas
        BotonInventarioHerramienta botonHerramienta;

        botonHerramienta = new BotonInventarioHerramienta(new Image("file:src/Vista/Imagenes/BotonHachaMadera.png")
                , constructor.crearHachaDeMadera(), jugador, inventarioLayout);
        botonHerramienta.actualizarCantidad();
        this.add(botonHerramienta, 0, 0, 1, 1);

        botonHerramienta = new BotonInventarioHerramienta(new Image("file:src/Vista/Imagenes/BotonHachaPiedra.png")
                ,constructor.crearHachaDePiedra(), jugador, inventarioLayout);
        this.add(botonHerramienta, 1, 0, 1, 1);

        botonHerramienta = new BotonInventarioHerramienta(new Image("file:src/Vista/Imagenes/BotonHachaMetal.png")
                ,constructor.crearHachaDeMetal(), jugador, inventarioLayout);
        this.add(botonHerramienta, 2, 0, 1, 1);

        botonHerramienta = new BotonInventarioHerramienta(new Image("file:src/Vista/Imagenes/BotonPicoMadera.png")
                ,constructor.crearPicoDeMadera(), jugador, inventarioLayout);
        this.add(botonHerramienta, 3, 0, 1, 1);

        botonHerramienta = new BotonInventarioHerramienta(new Image("file:src/Vista/Imagenes/BotonPicoPiedra.png")
                ,constructor.crearPicoDePiedra(), jugador, inventarioLayout);
        this.add(botonHerramienta, 4, 0, 1, 1);

        botonHerramienta = new BotonInventarioHerramienta(new Image("file:src/Vista/Imagenes/BotonPicoMetal.png")
                ,constructor.crearPicoDeMetal(), jugador, inventarioLayout);
        this.add(botonHerramienta, 5, 0, 1, 1);

        botonHerramienta = new BotonInventarioHerramienta(new Image("file:src/Vista/Imagenes/BotonPicoFino.png")
                ,constructor.crearPicoDePiedraRefinada(), jugador, inventarioLayout);
        this.add(botonHerramienta, 6, 0, 1, 1);

        //Relleno con botones vacios
        BotonVacio botonVacio;
        for(int i=7; i<9; i++){
            botonVacio = new BotonVacio(new Image("file:src/Vista/Imagenes/BotonVacio.png"));
            this.add(botonVacio, i, 0, 1, 1);
        }
    }
        public void actualizar(){
            for (Node child : this.getChildren()){
                if(child instanceof BotonInventarioHerramienta){
                    ((BotonInventarioHerramienta)child).actualizarCantidad();
                }
            }
        }
}
