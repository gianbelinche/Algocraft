import javafx.scene.Group;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Tablero {

    private Posicionable [][] mapa;
    private int ancho;
    private int alto;

    public Tablero(int anchoPasado, int altoPasado){
        ancho = anchoPasado;
        alto = altoPasado;
        mapa = new Posicionable[ancho][alto];

    }

    private boolean validarPosicion(int x, int y){
        if(x >= ancho || x < 0) return false;
        if(y >= alto  || y < 0) return false;
        return true;
    }

    public void colocarEnPosicion(int x, int y, Posicionable objetoColocado){
        if(!validarPosicion(x,y)) return;
        mapa[x][y] = objetoColocado;
    }

    public void borrarEnPosicion(int x, int y){
        if(validarPosicion(x,y)) mapa[x][y] = null;
    }

    public Posicionable obtenerDePosicion(int x, int y){
        return mapa[x][y];
    }

    public void dibujar(GraphicsContext gc){

        Proyector proyector = new Proyector();
        Posicionable posicionable;
        Image imagen;

        for(int i = 0;i < ancho;i++)
        {
            for(int j = 0;j < alto;j++)
            {
               posicionable =  obtenerDePosicion(i,j);

               if(posicionable != null)
               {
                   imagen = posicionable.imagen();
                   int imgXIso = proyector.obtenerXIso(i,j);
                   int imgYIso = proyector.obtenerYIso(i,j);
                   gc.drawImage(imagen,imgXIso,imgYIso);
               }
            }
        }
    }
}