package Vista.VentanaJuego.VentanaInventario.Botones;

import Controlador.BotonesHandlers.BotonMesaCrafteoHandler;
import Modelo.Construccion.Receta;
import Modelo.Jugador;
import Vista.VentanaJuego.VentanaInventario.MaterialSeleccionado;
import javafx.scene.control.Button;

public class BotonMesaCrafteo extends Button {
    Receta receta;
    MaterialSeleccionado material;
    int x;
    int y;
    public BotonMesaCrafteo(Jugador jugador, Receta receta, MaterialSeleccionado materialSeleccionado, int x, int y){
        this.receta = receta;
        this.material = materialSeleccionado;
        this.x = x;
        this.y = y;

        BotonMesaCrafteoHandler handler = new BotonMesaCrafteoHandler(jugador, receta,materialSeleccionado,x,y);
        this.setOnAction(handler);
        //Transparenta el boton
        //setStyle("-fx-background-color: transparent");
    }


}
