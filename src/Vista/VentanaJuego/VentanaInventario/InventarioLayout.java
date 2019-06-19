package Vista.VentanaJuego.VentanaInventario;

import Controlador.SalirDeInventarioHandler;
import Modelo.Almacenable;
import Vista.VentanaJuego.VentanaInventario.Botones.BotonInventario;
import Vista.VentanaJuego.VentanaInventario.Botones.BotonMesaCrafteo;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class InventarioLayout extends Pane {
    Stage stage;

    public InventarioLayout(Stage stage){

        super();
        this.setVisible(false);
        this.stage = stage;
        this.setPadding(new Insets(25));
        setPrefSize(stage.getWidth()*0.2, stage.getHeight()*0.3);

        //Alguna forma para no hardcodear??

        double Xposition = stage.getWidth()/2 - 200;;
        double Yposition = stage.getHeight()/2 - 200;
        this.setTranslateX(Xposition);
        this.setTranslateY(Yposition);

        Almacenable materialSeleccionado = null;

        //Cargo la imagen
        Image imagen = new Image("file:src/Vista/Imagenes/Inventario_crafteador.png");

        BackgroundImage imagenDeInventario = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
        new BackgroundSize(1.0, 1.0, true, true, false, false));
        this.setBackground(new Background(imagenDeInventario));

        //Creo botones
        this.setOnKeyPressed(new SalirDeInventarioHandler(this));


        //Creo botones de mesa de crafteo y los guardo en el GridPane
        GridPane mesaCrafteo = new GridPane();
        BotonMesaCrafteo[][] botonesMesa = new BotonMesaCrafteo[3][3];
        //Más hardcodeo :(
        mesaCrafteo.setTranslateX(63);
        mesaCrafteo.setTranslateY(25);
        mesaCrafteo.setPrefSize(114, 106);
        mesaCrafteo.setHgap(7);
        mesaCrafteo.setVgap(3);


        for(int i=0; i < 3; i++){
            for(int j=0; j<3; j++){
                botonesMesa[i][j] = new BotonMesaCrafteo(materialSeleccionado, j, i);
                //botones[i][j].setText(i + "," + j);
                mesaCrafteo.add(botonesMesa[i][j], j, i, 1, 1);
                botonesMesa[i][j].prefWidthProperty().bind(mesaCrafteo.widthProperty());
                botonesMesa[i][j].prefHeightProperty().bind(mesaCrafteo.heightProperty());
            }
        }

        //Armo el inventario con un GridPane
        GridPane inventario = new GridPane();

        BotonInventario[][] botonesInventario = new BotonInventario[3][9];
        //Aún más :(
        inventario.setTranslateX(15);
        inventario.setTranslateY(154);
        inventario.setPrefSize(354, 106);
        inventario.setHgap(9);
        inventario.setVgap(3);

        for(int i=0; i < 3; i++){
            for(int j=0; j<9; j++){
                botonesInventario[i][j] = new BotonInventario(materialSeleccionado, j, i);
                //botones[i][j].setText(i + "," + j);
                inventario.add(botonesInventario[i][j], j, i, 1, 1);
                botonesInventario[i][j].prefWidthProperty().bind(inventario.widthProperty());
                botonesInventario[i][j].prefHeightProperty().bind(inventario.heightProperty());
            }
        }



        this.getChildren().addAll(mesaCrafteo, inventario);
    }

}