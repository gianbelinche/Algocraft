package Controlador.BotonesHandlers;

import Modelo.Construccion.Receta;
import Modelo.Almacenable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonMesaCrafteoHandler implements EventHandler<ActionEvent> {
    Receta receta;
    Almacenable materialSeleccionado;
    int x;
    int y;
    public BotonMesaCrafteoHandler(Almacenable material, int x_pasado, int y_pasado){
        //Esto no anda, ¿crear clase MaterialSeleccionado?
        materialSeleccionado = material;
        x = x_pasado;
        y = y_pasado;
    }
    @Override
    public void handle(ActionEvent event){
        //Probar cambiar el tercer parametro de receta de "Material" a "Almacenable" o simplemente cambiar de Almacenable a Material en estos botones.
        //receta.posicionar(x,y, materialSeleccionado);
    }
}