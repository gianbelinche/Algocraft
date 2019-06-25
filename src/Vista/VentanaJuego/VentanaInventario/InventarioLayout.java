package Vista.VentanaJuego.VentanaInventario;

import Modelo.Construccion.Constructor;
import Modelo.Construccion.Receta;
import Modelo.Construccion.Recetario;
import Modelo.Juego;
import Modelo.Jugador;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InventarioLayout extends GridPane {
    Stage stage;

    public InventarioLayout(Stage stage, Juego juego){

        super();

        //Seteo el layout
        this.setVisible(false);
        this.stage = stage;
        this.setPrefSize(stage.getWidth()*0.3, stage.getHeight()*0.55);
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
        MesaCrafteo mesaCrafteo = new MesaCrafteo(stage, jugador, receta, materialSeleccionado);

        //Creo parte superior de Inventario
        InventarioMateriales materiales = new InventarioMateriales(materialSeleccionado, this);

        //Creo parte inferior de inventario
        InventarioHerramientas herramientas = new InventarioHerramientas(constructor,this);

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