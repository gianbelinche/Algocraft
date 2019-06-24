package Vista.VentanaJuego.VentanaInventario.Botones;

import Controlador.BotonesHandlers.BotonMesaCrafteoHandler;
import Modelo.Almacenable;
import Modelo.Construccion.Receta;
import javafx.scene.control.Button;

public class BotonMesaCrafteo extends Button {
    Receta receta;
    Almacenable material;
    int x;
    int y;
    public BotonMesaCrafteo(Receta receta, Almacenable materialSeleccionado, int x, int y){
        this.receta = receta;
        this.material = materialSeleccionado;
        this.x = x;
        this.y = y;

        BotonMesaCrafteoHandler handler = new BotonMesaCrafteoHandler(receta,materialSeleccionado,x,y);
        this.setOnAction(handler);
        //Transparenta el boton
        //setStyle("-fx-background-color: transparent");
        /*BotonMesaCrafteoHandler botonMesaHandler = new BotonMesaCrafteoHandler(materialSeleccionado, x, y);
        this.setOnAction(botonMesaHandler);*/
    }


}
