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

    public void mover(int incrementoX, int incrementoY){
        int escalaDeMovimiento = tablero.mover(x,y,incrementoX,incrementoY);
        x += incrementoX*escalaDeMovimiento;
        y += incrementoY*escalaDeMovimiento;
    }

    public void moverDerecha(){
        mover(1,0);
    }

    public void moverIzquierda(){
        mover(-1,0);
    }

    public void moverArriba(){
        mover(0,-1);
    }

    public void moverAbajo(){
        mover(0,1);
    }

    //Hacen falta?

    public int getX() {return x;}
    public int getY() {return y;}
}
