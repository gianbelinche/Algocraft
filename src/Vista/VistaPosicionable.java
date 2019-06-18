package Vista;

import Modelo.Escenario.Posicionable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class VistaPosicionable {

    Proyector proyector;

    public VistaPosicionable(){
        proyector = new Proyector();
    }

    public void dibujar(Posicionable posicionable, int x, int y, GraphicsContext gc){
        String ruta = posicionable.obtenerRutaImagen();
        int XIso = proyector.obtenerXIso(x,y);
        int YIso = proyector.obtenerYIso(x,y);
        gc.drawImage(new Image(ruta),XIso,YIso);

    }
}