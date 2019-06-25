package Vista.VentanaJuego.VentanaInventario;

import Modelo.Construccion.Receta;
import Modelo.Juego;
import Modelo.Jugador;
import Vista.VentanaJuego.VentanaInventario.Botones.BotonCraftear;
import Vista.VentanaJuego.VentanaInventario.Botones.BotonInventario;
import Vista.VentanaJuego.VentanaInventario.Botones.BotonMesaCrafteo;
import javafx.geometry.Pos;
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

        //Cargo jugador, receta y materialseleccionado
        Jugador jugador = juego.obtenerJugador();
        Receta receta = new Receta();
        MaterialSeleccionado materialSeleccionado = new MaterialSeleccionado();

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

        //Creo parte inferior de inventario
        GridPane herramientas = new GridPane();
        BotonInventario botonHerramienta;
        herramientas.setPrefSize(this.getPrefWidth()*0.5, this.getPrefHeight()*0.5);
        herramientas.setAlignment(Pos.CENTER);

        for(int i=0; i<9; i++){
            botonHerramienta = new BotonInventario(materialSeleccionado);
            herramientas.add(botonHerramienta, i, 0, 1, 1);
            botonHerramienta.setPrefSize(56,56);
        }

        //Armo el inventario con un GridPane
        GridPane materiales = new GridPane();

        BotonInventario botonesInventario;
        materiales.setPrefSize(this.getPrefWidth()*0.5, this.getPrefHeight()*0.5);
        materiales.setAlignment(Pos.BOTTOM_CENTER);

        for(int i=0; i < 3; i++){
            for(int j=0; j<9; j++){
                botonesInventario = new BotonInventario(materialSeleccionado);
                materiales.add(botonesInventario, j, i, 1, 1);
                botonesInventario.setPrefSize(56,56);
            }
        }

        VBox inventario = new VBox(materiales, herramientas);
        inventario.setAlignment(Pos.CENTER);

        this.add(mesaCrafteo, 0, 0, 1, 1);
        this.add(inventario,0,1,1,1);

        /////////////////////////////////////////


        //Seteo los botones con sus materiales
        //botonesInventario[0][0].setMaterial(new Madera());
        //botonesInventario[0][1].setMaterial(new Metal());
    }

    public void cambiarVisibilidad() {
        setVisible(!isVisible());
    }
}