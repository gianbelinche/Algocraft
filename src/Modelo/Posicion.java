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
    public void setX(int unX){
        x = unX;
    }
    public void setY(int unY){
        x = unY;
    }
    public void moverDerecha(Tablero tablero){
        if(tablero.moverObjeto(this.x, this.y, this.x+1, this.y)){
            this.x = this.x +1;
        }
    }
    public void moverIzquierda(Tablero tablero){
        if(tablero.moverObjeto(this.x, this.y, this.x-1, this.y)){
            this.x = this.x -1;
        }
    }
    public void moverArriba(Tablero tablero){
        if(tablero.moverObjeto(this.x, this.y, this.x, this.y-1)){
            this.y = this.y -1;
        }
    }
    public void moverAbajo(Tablero tablero){
        if(tablero.moverObjeto(this.x, this.y, this.x, this.y+1)){
            this.y = this.y +1;
        }
    }
}
