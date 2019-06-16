package Modelo;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Tablero {

    private Posicionable [][] mapa;
    private int ancho;
    private int alto;
    private PosicionVacia posicionVacia;

    public Tablero(int anchoPasado, int altoPasado){
        ancho = anchoPasado;
        alto = altoPasado;
        mapa = new Posicionable[ancho][alto];
        posicionVacia = new PosicionVacia();

        for(int i = 0;i < ancho;i++)
        {
            for(int j = 0;j < alto;j++)
            {
                colocarEnPosicion(i,j,posicionVacia);
            }
        }
    }

    private boolean validarPosicion(int x, int y){
        if(x >= ancho || x < 0) return false;
        if(y >= alto  || y < 0) return false;
        return true;
    }

    public void colocarEnPosicion(int x, int y, Posicionable objetoColocado){
        if(!validarPosicion(x,y)) return;
        mapa[x][y] = objetoColocado;
        Posicion nuevaPosicion = new Posicion(x,y,this);
        objetoColocado.establecerPosicion(nuevaPosicion);
    }

    public void borrarEnPosicion(int x, int y){
        mapa[x][y] = posicionVacia;
    }

    public Posicionable obtenerDePosicion(int x, int y){
        if(!validarPosicion(x,y)) return posicionVacia;
        return mapa[x][y];
    }

    public  int estaLibre(int x, int y)
    {
        if(!validarPosicion(x,y)) return 0;
        return obtenerDePosicion(x,y).estaLibre();
    }

    public void mover(int viejaX,int viejaY,int incrementoX, int incrementoY)
    {
        Posicionable objetoAMover = obtenerDePosicion(viejaX,viejaY);
        int escalaDeMovimiento = estaLibre(viejaX + incrementoX,viejaY + incrementoY);
        int nuevaX = viejaX + incrementoX*escalaDeMovimiento;
        int nuevaY = viejaY + incrementoY*escalaDeMovimiento;

        borrarEnPosicion(viejaX,viejaY);
        colocarEnPosicion(nuevaX,nuevaY,objetoAMover);
    }

    public boolean esIgual(Tablero otroTablero){
        for(int i = 0;i < ancho;i++)
        {
            for(int j = 0;j < alto;j++)
            {
                if (!(this.obtenerDePosicion(i,j).esIgual(otroTablero.obtenerDePosicion(i,j)))) return false;
            }
        }
        return true;
    }

    public void dibujar(GraphicsContext terreno){

        Proyector proyector = new Proyector();
        Posicionable posicionable;

        for(int i = 0;i < ancho;i++)
        {
            for(int j = 0;j < alto;j++)
            {
                int imgXIso = proyector.obtenerXIso(i,j);
                int imgYIso = proyector.obtenerYIso(i,j);

                posicionable =  obtenerDePosicion(i,j);
                if(posicionable != null)  posicionable.dibujar(imgXIso,imgYIso,terreno);
            }
        }
    }
}