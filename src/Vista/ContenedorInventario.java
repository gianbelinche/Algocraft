package Vista;

import javafx.scene.layout.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ContenedorInventario extends VBox {
    Stage stage;
    public ContenedorInventario(Stage stage){

        super();
        this.stage = stage;
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));
        //Cargo la imagen
        Image imagen = new Image("file:src/Vista/Imagenes/Fondo_con_inventario.png");

        BackgroundImage imagenDeInventario = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
        new BackgroundSize(1.0, 1.0, true, true, false, false));
        this.setBackground(new Background(imagenDeInventario));

        //Creo los botones y los guardo en el GridPane
        GridPane mesaCrafteo = new GridPane();
        BotonMesaCrafteo[][] botones = new BotonMesaCrafteo[3][3];

        for(int i=0; i < 3; i++){
            for(int j=0; j<3; j++){
                botones[i][j] = new BotonMesaCrafteo();
                botones[i][j].setText(i + "," + j);
                mesaCrafteo.add(botones[i][j], j, i, 1, 1);
            }
        }



        this.getChildren().addAll(mesaCrafteo);
    }

}