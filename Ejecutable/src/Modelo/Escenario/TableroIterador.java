package Modelo.Escenario;

public class TableroIterador {
    private Tablero tablero;
    private int ancho;
    private int alto;
    private int largo;
    private int x;
    private int y;
    private int z;

    public TableroIterador(Tablero nuevoTablero,int nuevoAncho, int nuevoLargo,int nuevoAlto){
      tablero = nuevoTablero;
      ancho = nuevoAncho; largo = nuevoLargo; alto = nuevoAlto;
      x = 0;y = 0;z = alto - 1;
    }

    public boolean haFinalizado(){
        return (x == 0 && y == largo && z == alto - 1);
    }

    public Posicionable verActual(){
        return tablero.obtenerDePosicion(x,y,z);
    }

    public void colocarEnActual(Posicionable posicionable){
        tablero.colocarEnPosicion(x,y,z,posicionable);
    }

    public void borrarEnActual(){
        tablero.borrarEnPosicion(x,y,z);
    }

    public void avanzar(){
        x++;
        if(x == ancho){
            x = 0;z--;
        }
        if(z < 0){
           x = 0;y++;z = alto - 1;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }
}
