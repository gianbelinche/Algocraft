package Modelo;

public class Tablero {

    private Object [][] mapa;
    private int ancho;
    private int alto;

    public Tablero(int anchoPasado, int altoPasado){
        ancho = anchoPasado;
        alto = altoPasado;
        mapa = new Object[ancho][alto];
    }

    public void colocarEnPosicion(int x, int y, Object objeto){
        if(!validarPosicion(x,y)){
            return; // CAMBIAR PARA LANZAR EXCEPCION
        }
        mapa[x][y] = objeto;
    }

    private boolean validarPosicion(int x, int y){
        if(x>=ancho || x < 0){
            return false;
        }
        if(y>=alto || y < 0){
            return false;
        }
        return true;
    }

    public Object obtenerDePosicion(int x, int y){
        if(!validarPosicion(x,y)){
            return null; // CAMBIAR PARA LANZAR EXCEPCION
        }
        return mapa[x][y];
    }

    public int moverDerecha(int x, int y){
        if(!validarPosicion(x,y) || (obtenerDePosicion(x+1, y) != null)) return x;
        colocarEnPosicion(x+1, y, obtenerDePosicion(x,y));
        colocarEnPosicion(x, y,null);
        return x+1;
    }

    public int moverIzquierda(int x, int y){
        if(!validarPosicion(x,y) || (obtenerDePosicion(x-1, y) != null)) return x;
        colocarEnPosicion(x-1, y, obtenerDePosicion(x,y));
        colocarEnPosicion(x, y,null);
        return x-1;
    }

    public int moverAbajo(int x, int y){
        if(!validarPosicion(x,y) || (obtenerDePosicion(x, y+1) != null)) return y;
        colocarEnPosicion(x, y+1, obtenerDePosicion(x,y));
        colocarEnPosicion(x, y,null);
        return y+1;
    }

    public int moverArriba(int x, int y){
        if(!validarPosicion(x,y) || (obtenerDePosicion(x, y-1) != null)) return y;
        colocarEnPosicion(x, y-1, obtenerDePosicion(x,y));
        colocarEnPosicion(x, y,null);
        return y-1;
    }


}