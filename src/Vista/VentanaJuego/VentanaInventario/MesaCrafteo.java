package Vista.VentanaJuego.VentanaInventario;

import Modelo.Construccion.Receta;
import Modelo.Jugador.Jugador;
import Vista.VentanaJuego.VentanaInventario.Botones.BotonCraftear;
import Vista.VentanaJuego.VentanaInventario.Botones.BotonMesaCrafteo;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MesaCrafteo extends GridPane {

    public MesaCrafteo(Stage stage, Jugador jugador, Receta receta, MaterialSeleccionado materialSeleccionado, InventarioLayout inventarioLayout) {
        this.setPrefSize(inventarioLayout.getPrefWidth()*0.85, inventarioLayout.getPrefHeight()*0.8);
        BotonMesaCrafteo botonesMesa;
        this.setAlignment(Pos.TOP_CENTER);
        this.setTranslateY(stage.getHeight()*0.02);

        //Pongo botones en mesa de crafteo

        for(int i=0; i < 3; i++){
            for(int j=0; j<3; j++){
                botonesMesa = new BotonMesaCrafteo(jugador, receta, materialSeleccionado, inventarioLayout,i,j);
                this.add(botonesMesa, j, i, 1, 1);
                botonesMesa.setPrefSize(inventarioLayout.getPrefWidth()*0.105,inventarioLayout.getPrefHeight()*0.105);
            }
        }

        //Creo boton de craftear
        BotonCraftear botonCraftear = new BotonCraftear(receta,jugador, inventarioLayout,this);
        botonCraftear.setPrefWidth(inventarioLayout.getPrefWidth()*0.18);
        botonCraftear.setPrefHeight(inventarioLayout.getPrefHeight()*0.16);
        this.add(botonCraftear, 5,0,3,3);
    }

    public void vaciar(){
        for (Node child : this.getChildren()){
            if (child instanceof BotonMesaCrafteo){
                ((BotonMesaCrafteo) child).ponerFondoVacio();
            }
        }
    }
}
