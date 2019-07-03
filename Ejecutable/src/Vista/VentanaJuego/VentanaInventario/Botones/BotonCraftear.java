package Vista.VentanaJuego.VentanaInventario.Botones;


import Controlador.BotonesHandlers.BotonCraftearHandler;
import Modelo.Construccion.Receta;
import Modelo.ElementosJugador.Jugador;
import Vista.VentanaJuego.VentanaInventario.InventarioLayout;
import Vista.VentanaJuego.VentanaInventario.MesaCrafteo;
import javafx.scene.control.Button;

public class BotonCraftear extends Button {
    public BotonCraftear(Receta receta, Jugador jugador, InventarioLayout inventarioLayout, MesaCrafteo mesa){
        this.setText("Craftear");
        BotonCraftearHandler handler = new BotonCraftearHandler(receta,jugador, inventarioLayout,mesa);
        this.setTranslateX(30);
        this.setOnAction(handler);
    }
}
