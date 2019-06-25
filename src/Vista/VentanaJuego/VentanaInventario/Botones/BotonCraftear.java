package Vista.VentanaJuego.VentanaInventario.Botones;


import Controlador.BotonesHandlers.BotonCraftearHandler;
import Modelo.Construccion.Receta;
import Modelo.Construccion.Recetario;
import Modelo.Inventario;
import Modelo.Jugador;
import Vista.VentanaJuego.VentanaInventario.InventarioLayout;
import javafx.scene.control.Button;

public class BotonCraftear extends Button {
    public BotonCraftear(Receta receta, Jugador jugador, InventarioLayout inventarioLayout){
        this.setText("Craftear");
        BotonCraftearHandler handler = new BotonCraftearHandler(receta,jugador, inventarioLayout);
        this.setTranslateX(30);
        this.setOnAction(handler);
    }
}
