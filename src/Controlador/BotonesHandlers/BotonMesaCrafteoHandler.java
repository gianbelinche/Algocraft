package Controlador.BotonesHandlers;

import Modelo.Construccion.Receta;
import Modelo.Almacenable;
import Modelo.Jugador;
import Modelo.Materiales.Material;
import Vista.VentanaJuego.VentanaInventario.MaterialSeleccionado;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonMesaCrafteoHandler implements EventHandler<ActionEvent> {
    Receta receta;
    MaterialSeleccionado materialSeleccionado;
    Jugador jugador;
    int x;
    int y;
    public BotonMesaCrafteoHandler(Jugador jugador, Receta receta, MaterialSeleccionado material, int x_pasado, int y_pasado){
        this.receta = receta;
        materialSeleccionado = material;
        x = x_pasado;
        y = y_pasado;
        this.jugador = jugador;

    }
    @Override
    public void handle(ActionEvent event){
        //Ojo, hay que pedirle al inventario el material, no usar directamente el materialSeleccionado
        Material material = materialSeleccionado.obtenerSeleccionado();
        if (material != null) {
            Material materialInventario = (Material) jugador.obtenerDeInventario(material);
            this.receta.posicionar(x,y, materialInventario);
        }
        
        //Probar cambiar el tercer parametro de receta de "Material" a "Almacenable" o simplemente cambiar de Almacenable a Material en estos botones.
        //receta.posicionar(x,y, materialSeleccionado);
    }
}