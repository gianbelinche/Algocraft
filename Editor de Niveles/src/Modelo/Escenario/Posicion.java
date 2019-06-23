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

    public int getX() {return x;}

    public int getY() {return y;}

    public int getZ() {return z;}
}
