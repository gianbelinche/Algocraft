package Vista;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Vista {
    String sprite;
    Proyector proyector;

    public Vista(String ruta){
        sprite = ruta;
        proyector = new Proyector();
    }

    public void dibujar(int x, int y, GraphicsContext gc){
        int XIso = proyector.obtenerXIso(x,y);
        int YIso = proyector.obtenerYIso(x,y);
        gc.drawImage(new Image(sprite),XIso,YIso);
    }
}
