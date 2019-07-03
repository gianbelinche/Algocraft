package Vista.VentanaJuego.VentanaTablero;

import Controlador.BotonesHandlers.BotonReiniciarJuegoHandler;
import Vista.Ventana;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class BotonReiniciarJuego extends Button {

    public BotonReiniciarJuego(Ventana ventana, Stage mainStage){
        this.setText("Reiniciar");
        this.setOnAction(new BotonReiniciarJuegoHandler(ventana, mainStage));
    }

}
