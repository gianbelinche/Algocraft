package Modelo.Escenario;

import javafx.geometry.Pos;

public class TableroIterador {
    private Tablero tablero;
    private int ancho;
    private int alto;
    private int x;
    private int y;

    public TableroIterador(Tablero nuevoTablero,int nuevoAncho, int nuevoAlto){
      tablero = nuevoTablero;
      ancho = nuevoAncho;
      alto = nuevoAlto;
      x = 0;
      y = 0;
    }

    public boolean haFinalizado(){
        return (x == (ancho - 1) && y == (alto - 1));
    }

    public Posicionable verActual(){
        return tablero.obtenerDePosicion(x,y);
    }

    public void colocarEnActual(Posicionable posicionable){
        tablero.colocarEnPosicion(x,y,posicionable);
    }

    public void borrarEnActual(){
        tablero.borrarEnPosicion(x,y);
    }

    public void avanzar(){
        x++;
        if(x == ancho){
            y++;
            x = 0;
        }
    }

}
