package Vista.VentanaJuego.VentanaInventario;

import Modelo.Construccion.Constructor;
import Modelo.Construccion.Receta;
import Modelo.Juego;
import Modelo.ElementosJugador.*;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InventarioLayout extends GridPane {
    Stage stage;
    InventarioMateriales inventarioMateriales;
    InventarioHerramientas inventarioHerramientas;

    public InventarioLayout(Stage stage, Juego juego){

        super();

        //Seteo el layout
        this.setVisible(false);
        this.stage = stage;
        this.setPrefSize(stage.getWidth()*0.38, stage.getHeight()*0.6);
        this.setTranslateX(stage.getWidth()*0.35);
        this.setTranslateY(stage.getHeight()*0.25);
        this.setAlignment(Pos.CENTER);
        this.setStyle("-fx-background-color: rgb(176,176,176)");

        //Cargo jugador, receta, materialseleccionado y constructor
        Jugador jugador = juego.obtenerJugador();
        Receta receta = juego.obtenerReceta();
        MaterialSeleccionado materialSeleccionado = new MaterialSeleccionado();
        Constructor constructor = new Constructor();

        //Creo de mesa de crafteo
        MesaCrafteo mesaCrafteo = new MesaCrafteo(stage, jugador, receta, materialSeleccionado, this);

        //Creo parte superior de Inventario
        inventarioMateriales = new InventarioMateriales(materialSeleccionado, this, jugador);

        //Creo parte inferior de inventario
        inventarioHerramientas = new InventarioHerramientas(constructor,this, jugador);

        //Creo inventario completo
        VBox inventario = new VBox(inventarioMateriales, inventarioHerramientas);
        inventario.setAlignment(Pos.CENTER);

        this.add(mesaCrafteo, 0, 0, 1, 1);
        this.add(inventarioHerramientas, 0, 1, 2, 2);
        this.add(inventarioMateriales, 0, 2, 1, 1);

    }

    public void cambiarVisibilidad() {
        setVisible(!isVisible());
    }
    public void actualizarHerramientas(){
        inventarioHerramientas.actualizar();
    }
    public void actualizarMateriales(){
        inventarioMateriales.actualizar();
    }
}
