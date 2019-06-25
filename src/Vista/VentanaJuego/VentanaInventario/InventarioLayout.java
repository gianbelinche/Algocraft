package Vista.VentanaJuego.VentanaInventario;

import Modelo.Construccion.Constructor;
import Modelo.Construccion.Receta;
import Modelo.Juego;
import Modelo.Jugador;
import Modelo.Materiales.Madera;
import Vista.VentanaJuego.VentanaInventario.Botones.BotonCraftear;
import Vista.VentanaJuego.VentanaInventario.Botones.BotonInventario;
import Vista.VentanaJuego.VentanaInventario.Botones.BotonInventarioHerramienta;
import Vista.VentanaJuego.VentanaInventario.Botones.BotonMesaCrafteo;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InventarioLayout extends GridPane {
    Stage stage;

    public InventarioLayout(Stage stage, Juego juego){

        super();

        //Seteo el layout
        this.setVisible(false);
        this.stage = stage;
        this.setPrefSize(stage.getWidth()*0.3, stage.getHeight()*0.5);
        this.setTranslateX(stage.getWidth()*0.35);
        this.setTranslateY(stage.getHeight()*0.25);
        this.setAlignment(Pos.CENTER);
        this.setStyle("-fx-background-color: rgb(176,176,176)");

        //Creo de mesa de crafteo
        GridPane mesaCrafteo = new GridPane();
        mesaCrafteo.setPrefSize(530, 480);
        BotonMesaCrafteo botonesMesa;
        mesaCrafteo.setAlignment(Pos.TOP_CENTER);
        mesaCrafteo.setTranslateY(stage.getHeight()*0.02);

        //Cargo jugador, receta, materialseleccionado y constructor
        Jugador jugador = juego.obtenerJugador();
        Receta receta = new Receta();
        MaterialSeleccionado materialSeleccionado = new MaterialSeleccionado();
        Constructor constructor = new Constructor();

        //Pongo botones en mesa de crafteo

        for(int i=0; i < 3; i++){
            for(int j=0; j<3; j++){
                botonesMesa = new BotonMesaCrafteo(jugador, receta, materialSeleccionado);
                mesaCrafteo.add(botonesMesa, j, i, 1, 1);
                botonesMesa.setPrefSize(56,56);
            }
        }

        //Creo boton de craftear
        BotonCraftear botonCraftear = new BotonCraftear(receta,jugador);
        botonCraftear.setPrefWidth(80);
        botonCraftear.setPrefHeight(80);
        mesaCrafteo.add(botonCraftear, 5,0,3,3);

        //Armo el inventario con un GridPane
        GridPane materiales = new GridPane();

        BotonInventario botonesInventario;
        materiales.setPrefSize(this.getPrefWidth()*0.5, this.getPrefHeight()*0.5);
        materiales.setAlignment(Pos.BOTTOM_CENTER);

        for(int i=0; i < 3; i++){
            for(int j=0; j<9; j++){
                botonesInventario = new BotonInventario(materialSeleccionado, new Image("file:src/Vista/Imagenes/BotonVacio.png"));
                materiales.add(botonesInventario, j, i, 1, 1);
                botonesInventario.setPrefSize(56,56);
            }
        }

        //Creo parte inferior de inventario
        GridPane herramientas = new GridPane();
        BotonInventarioHerramienta botonHerramienta;
        herramientas.setPrefSize(this.getPrefWidth()*0.5, this.getPrefHeight()*0.5);
        herramientas.setAlignment(Pos.CENTER);

        //Creo botones de herramientas
        botonHerramienta = new BotonInventarioHerramienta(constructor.crearHachaDeMadera(), new Image("file:src/Vista/Imagenes/BotonHachaMadera.png"));
        herramientas.add(botonHerramienta, 0, 0, 1, 1);
        botonHerramienta = new BotonInventarioHerramienta(constructor.crearHachaDePiedra(), new Image("file:src/Vista/Imagenes/BotonHachaPiedra.png"));
        herramientas.add(botonHerramienta, 1, 0, 1, 1);
        botonHerramienta = new BotonInventarioHerramienta(constructor.crearHachaDeMetal(), new Image("file:src/Vista/Imagenes/BotonHachaMetal.png"));
        herramientas.add(botonHerramienta, 2, 0, 1, 1);
        botonHerramienta = new BotonInventarioHerramienta(constructor.crearPicoDeMadera(), new Image("file:src/Vista/Imagenes/BotonPicoMadera.png"));
        herramientas.add(botonHerramienta, 3, 0, 1, 1);
        botonHerramienta = new BotonInventarioHerramienta(constructor.crearPicoDePiedra(), new Image("file:src/Vista/Imagenes/BotonPicoPiedra.png"));
        herramientas.add(botonHerramienta, 4, 0, 1, 1);
        botonHerramienta = new BotonInventarioHerramienta(constructor.crearPicoDeMetal(), new Image("file:src/Vista/Imagenes/BotonPicoMetal.png"));
        herramientas.add(botonHerramienta, 5, 0, 1, 1);
        botonHerramienta = new BotonInventarioHerramienta(constructor.crearPicoDePiedraRefinada(), new Image("file:src/Vista/Imagenes/BotonPicoFino.png"));
        herramientas.add(botonHerramienta, 6, 0, 1, 1);
        for(int i=7; i<9; i++){
            botonHerramienta = new BotonInventarioHerramienta(null, new Image("file:src/Vista/Imagenes/BotonVacio.png"));
            herramientas.add(botonHerramienta, i, 0, 1, 1);
        }

        //Creo inventario completo
        VBox inventario = new VBox(materiales, herramientas);
        inventario.setAlignment(Pos.CENTER);

        this.add(mesaCrafteo, 0, 0, 1, 1);
        this.add(inventario,0,1,1,1);
    }

    public void cambiarVisibilidad() {
        setVisible(!isVisible());
    }
}