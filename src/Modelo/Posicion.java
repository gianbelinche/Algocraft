package Modelo;

public class Posicion {

    private int x;
    private int y;
    private Tablero tablero;

    public Posicion(int unX, int unY, Tablero unTablero){
        x = unX;
        y = unY;
        tablero = unTablero;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void setX(int unX){
        x = unX;
    }

    public void setY(int unY){
        x = unY;
    }

    public void moverDerecha(){
        this.x = tablero.moverDerecha(this.x, this.y);
    }

    public void moverIzquierda(){
        this.x = tablero.moverIzquierda(this.x, this.y);
    }

    public void moverArriba(){
        this.y = tablero.moverArriba(this.x, this.y);
    }

    public void moverAbajo(){
        this.y = tablero.moverAbajo(this.x, this.y);
    }

}
