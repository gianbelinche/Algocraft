package Controlador.BotonesHandlers;

import Modelo.Almacenable;
import Modelo.Construccion.Receta;
import Modelo.Construccion.Recetario;
import Modelo.Herramientas.Herramienta;
import Modelo.Inventario;
import Modelo.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class BotonCraftearHandler implements EventHandler<javafx.event.ActionEvent> {
    Receta receta;
    Jugador jugador;
    Recetario recetario;

    public BotonCraftearHandler(Receta receta, Jugador jugador){
        this.receta = receta;
        this.jugador = jugador;
        this.recetario = recetario;

    }


    public void handle(ActionEvent event){
        Recetario recetario =  new Recetario();
        Herramienta herramienta = recetario.craftear(receta);

        if (herramienta == null) {
            devolverAlmacenables(receta,jugador);
        } else {
            jugador.guardarEnInventario(herramienta);
        }
        receta.vaciar();

    }

    private void devolverAlmacenables(Receta receta, Jugador jugador){
        for(int i =0;i<3;i++){
            for(int j=0;j<3;j++){
                Almacenable almacenable = receta.enPosicion(i,j);
                if (almacenable != null){
                    jugador.guardarEnInventario(almacenable);
                }
            }
        }
    }
}
