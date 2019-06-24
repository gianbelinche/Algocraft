package Vista.VentanaJuego.VentanaInventario.Botones;


import Controlador.BotonesHandlers.BotonCraftearHandler;
import Modelo.Construccion.Receta;
import Modelo.Inventario;
import Modelo.Jugador;
import javafx.scene.control.Button;

public class BotonCraftear extends Button {
    public BotonCraftear(Receta receta, Jugador jugador){
        this.setText("Craftear");
        BotonCraftearHandler handler = new BotonCraftearHandler(receta,jugador);
        this.setOnAction(handler);
    }
}
