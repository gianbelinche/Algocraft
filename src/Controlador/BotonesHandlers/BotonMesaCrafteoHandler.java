package Controlador.BotonesHandlers;

import Modelo.Construccion.Receta;
import Modelo.Almacenable;
import Modelo.Materiales.Material;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonMesaCrafteoHandler implements EventHandler<ActionEvent> {
    Receta receta;
    Almacenable materialSeleccionado;
    int x;
    int y;
    public BotonMesaCrafteoHandler(Receta receta,Almacenable material, int x_pasado, int y_pasado){
        //Esto no anda, ¿crear clase MaterialSeleccionado?
        this.receta = receta;
        materialSeleccionado = material;
        x = x_pasado;
        y = y_pasado;
    }
    @Override
    public void handle(ActionEvent event){
        this.receta.posicionar(x,y, (Material) materialSeleccionado);
        //Probar cambiar el tercer parametro de receta de "Material" a "Almacenable" o simplemente cambiar de Almacenable a Material en estos botones.
        //receta.posicionar(x,y, materialSeleccionado);
    }
}