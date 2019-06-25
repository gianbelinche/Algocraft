package Vista.VentanaJuego.VentanaInventario.Botones;

import Controlador.BotonesHandlers.BotonMesaCrafteoHandler;
import Modelo.Construccion.Receta;
import Modelo.Jugador;
import Vista.VentanaJuego.VentanaInventario.MaterialSeleccionado;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class BotonMesaCrafteo extends Button {
    Receta receta;
    MaterialSeleccionado material;
    int x;
    int y;
    public BotonMesaCrafteo(Jugador jugador, Receta receta, MaterialSeleccionado materialSeleccionado){

        Image image = new Image("file:src/Vista/Imagenes/BotonVacio.png");

        BackgroundImage backgroundImage = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(1.0, 1.0, true, true, false, false));
        this.setBackground(new Background(backgroundImage));

        this.receta = receta;
        this.material = materialSeleccionado;

        BotonMesaCrafteoHandler handler = new BotonMesaCrafteoHandler(jugador, receta,materialSeleccionado,x,y);
        this.setOnAction(handler);
    }


}
