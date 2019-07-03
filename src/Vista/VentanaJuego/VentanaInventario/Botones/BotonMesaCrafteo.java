package Vista.VentanaJuego.VentanaInventario.Botones;

import Controlador.BotonesHandlers.BotonMesaCrafteoHandler;
import Modelo.Construccion.Receta;
import Modelo.ElementosJugador.Jugador;
import Vista.VentanaJuego.VentanaInventario.InventarioLayout;
import Vista.VentanaJuego.VentanaInventario.MaterialSeleccionado;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class BotonMesaCrafteo extends Button {
    Receta receta;
    MaterialSeleccionado material;
    BackgroundImage backgroundVacio;
    public BotonMesaCrafteo(Jugador jugador, Receta receta, MaterialSeleccionado materialSeleccionado, InventarioLayout inventarioLayout, int x, int y){

        Image image = new Image("file:src/Vista/Imagenes/BotonVacio.png");

        BackgroundImage backgroundImage = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(1.0, 1.0, true, true, false, false));
        this.backgroundVacio = backgroundImage;
        this.setBackground(new Background(backgroundImage));

        this.receta = receta;
        this.material = materialSeleccionado;

        BotonMesaCrafteoHandler handler = new BotonMesaCrafteoHandler(jugador, receta,materialSeleccionado, inventarioLayout,x,y,this);
        this.setOnAction(handler);
    }

    public void ponerFondoVacio(){
        this.setBackground(new Background(backgroundVacio));
    }



}
