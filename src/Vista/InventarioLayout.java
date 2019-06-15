package Vista;

import Controlador.SalirDeInventarioHandler;
import javafx.scene.layout.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class InventarioLayout extends Pane {
    Stage stage;

    public InventarioLayout(Stage stage){

        super();
        this.setVisible(false);
        this.stage = stage;
        this.setPadding(new Insets(25));
        this.setTranslateX(stage.getWidth()/2 - getWidth());
        this.setTranslateY(stage.getHeight()/2 - 100);
        setMaxSize(200, 200);
        //Cargo la imagen
        Image imagen = new Image("file:src/Vista/Imagenes/Inventario_crafteador.png");

        BackgroundImage imagenDeInventario = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
        new BackgroundSize(1.0, 1.0, true, true, false, false));
        this.setBackground(new Background(imagenDeInventario));

        //Creo botones
        this.setOnKeyPressed(new SalirDeInventarioHandler(this));


        //Creo los botones y los guardo en el GridPane
        GridPane mesaCrafteo = new GridPane();
        mesaCrafteo.setMaxSize(50, 50 );
        BotonMesaCrafteo[][] botones = new BotonMesaCrafteo[3][3];

        mesaCrafteo.prefWidth(this.getWidth()/2);
        mesaCrafteo.prefHeight(this.getHeight()/2);

        for(int i=0; i < 3; i++){
            for(int j=0; j<3; j++){
                botones[i][j] = new BotonMesaCrafteo();
                botones[i][j].setText(i + "," + j);
                mesaCrafteo.add(botones[i][j], j, i, 1, 1);
                botones[i][j].prefWidthProperty().bind(mesaCrafteo.widthProperty());
                botones[i][j].prefHeightProperty().bind(mesaCrafteo.heightProperty());
            }
        }



        this.getChildren().addAll(mesaCrafteo);
    }

}