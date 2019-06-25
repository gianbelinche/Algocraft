package Vista.VentanaJuego.VentanaInventario;

import Modelo.Construccion.Receta;
import Modelo.Juego;
import Modelo.Jugador;
import Modelo.Materiales.Madera;
import Modelo.Materiales.Metal;
import Vista.VentanaJuego.VentanaInventario.Botones.BotonCraftear;
import Vista.VentanaJuego.VentanaInventario.Botones.BotonInventario;
import Vista.VentanaJuego.VentanaInventario.Botones.BotonMesaCrafteo;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class InventarioLayout extends Pane {
    Stage stage;

    public InventarioLayout(Stage stage, Juego juego){

        super();
        this.setVisible(false);
        this.stage = stage;
        this.setPadding(new Insets(25));
        setPrefSize(stage.getWidth()*0.3, stage.getHeight()*0.45);

        //Alguna forma para no hardcodear??

        double Xposition = stage.getWidth()/2 - 200;
        double Yposition = stage.getHeight()/2 - 210;
        this.setTranslateX(Xposition);
        this.setTranslateY(Yposition);


        //Cargo jugador
        Jugador jugador = juego.obtenerJugador();


        //Cargo la imagen
        Image imagen = new Image("file:src/Vista/Imagenes/Inventario_crafteador.png");

        BackgroundImage imagenDeInventario = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
        new BackgroundSize(1.0, 1.0, true, true, false, false));
        this.setBackground(new Background(imagenDeInventario));

        //Creo botones de mesa de crafteo y los guardo en el GridPane
        GridPane mesaCrafteo = new GridPane();
        BotonMesaCrafteo[][] botonesMesa = new BotonMesaCrafteo[3][3];
        //Más hardcodeo :(
        mesaCrafteo.setTranslateX(64);
        mesaCrafteo.setTranslateY(29);
        mesaCrafteo.setPrefSize(120, 106);
        mesaCrafteo.setHgap(5);
        mesaCrafteo.setVgap(4);

        MaterialSeleccionado materialSeleccionado = new MaterialSeleccionado();

        Receta receta = new Receta();
        for(int i=0; i < 3; i++){
            for(int j=0; j<3; j++){
                botonesMesa[i][j] = new BotonMesaCrafteo(jugador, receta, materialSeleccionado, j, i);
                //botones[i][j].setText(i + "," + j);
                mesaCrafteo.add(botonesMesa[i][j], j, i, 1, 1);
                botonesMesa[i][j].prefWidthProperty().bind(mesaCrafteo.widthProperty());
                botonesMesa[i][j].prefHeightProperty().bind(mesaCrafteo.heightProperty());
            }
        }

        BotonCraftear botonCraftear = new BotonCraftear(receta,jugador);
        botonCraftear.setTranslateX(395);
        botonCraftear.setTranslateY(80);
        botonCraftear.setPrefSize(80,80);


        //Armo el inventario con un GridPane
        GridPane inventario = new GridPane();

        BotonInventario[][] botonesInventario = new BotonInventario[3][9];
        //Aún más :(
        inventario.setTranslateX(13);
        inventario.setTranslateY(168);
        inventario.setPrefSize(366, 108);
        inventario.setHgap(2);
        inventario.setVgap(3);

        for(int i=0; i < 3; i++){
            for(int j=0; j<9; j++){
                botonesInventario[i][j] = new BotonInventario(materialSeleccionado);
                //botones[i][j].setText(i + "," + j);
                inventario.add(botonesInventario[i][j], j, i, 1, 1);
                botonesInventario[i][j].prefWidthProperty().bind(inventario.widthProperty());
                botonesInventario[i][j].prefHeightProperty().bind(inventario.heightProperty());
            }
        }

        //Seteo los botones con sus materiales
        botonesInventario[0][0].setMaterial(new Madera());
        botonesInventario[0][1].setMaterial(new Metal());

        this.getChildren().addAll(mesaCrafteo, inventario, botonCraftear);
    }

    public void cambiarVisibilidad() {
        setVisible(!isVisible());
    }
}