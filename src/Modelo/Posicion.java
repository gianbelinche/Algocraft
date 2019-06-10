package Modelo;

public class Posicion {

    private int x;
    private int y;

    public Posicion(int unX, int unY){
        x = unX;
        y = unY;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void moverDerecha(Tablero tablero){
        this.x = tablero.moverDerecha(this.x, this.y);
    }

    public void moverIzquierda(Tablero tablero){
        this.x = tablero.moverIzquierda(this.x, this.y);
    }

    public void moverAbajo(Tablero tablero){
        this.y = tablero.moverAbajo(this.x, this.y);
    }

    public void moverArriba(Tablero tablero){
        this.y = tablero.moverArriba(this.x, this.y);
    }

}
