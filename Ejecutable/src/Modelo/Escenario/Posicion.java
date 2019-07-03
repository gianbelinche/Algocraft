package Modelo.Escenario;

public class Posicion {

    private int x;
    private int y;
    private int z;
    private Tablero tablero;

    public Posicion(int unX, int unY,int unZ, Tablero nuevoTablero){
        x = unX;
        y = unY;
        z = unZ;
        tablero = nuevoTablero;
    }

    public Posicion(int unX, int unY,int unZ){
        x = unX;
        y = unY;
        z = unZ;
        tablero = Tablero.obtenerTablero();
    }

    public void mover(int incrementoX, int incrementoY){
        tablero.mover(x,y,z,x + incrementoX,y + incrementoY,z);
    }

    public void moverDerecha(){
        mover(1,0);
    }

    public void moverIzquierda(){
        mover(-1,0);
    }

    public void moverArriba(){ mover(0,-1); }

    public void moverAbajo(){
        mover(0,1);
    }

    public void borrar(Posicionable objeto){
        tablero.borrarEnPosicion(x,y,z);
        objeto.establecerPosicion(null);
    }

    public int getX() {return x;}

    public int getY() {return y;}

    public int getZ() {return z;}
}
