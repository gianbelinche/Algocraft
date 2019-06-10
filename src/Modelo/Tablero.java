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

    private boolean validarPosicion(int x, int y){
        if(x>=ancho || x < 0){
            return false;
        }
        if(y>=alto || y < 0){
            return false;
        }
        return true;
    }

    public void colocarEnPosicion(int x, int y, Object objeto){
        if(!validarPosicion(x,y)){
            return; // CAMBIAR PARA LANZAR EXCEPCION
        }
        mapa[x][y] = objeto;
    }

    public Object obtenerDePosicion(int x, int y){
        if(!validarPosicion(x,y)){
            return null; // CAMBIAR PARA LANZAR EXCEPCION
        }
        return mapa[x][y];
    }

    public boolean moverObjeto(int x_prev, int y_prev, int x_nuev, int y_nuev){
        /*"Como sabe posicion si pude mover el objeto?"*/
        Object objeto = this.obtenerDePosicion(x_prev, y_prev);

        if(objeto == null){
            colocarEnPosicion(x_nuev, y_nuev, objeto);
            return true;
        }
        return false;
    }

}


    /*
    public void colocarEnPosicion(Posicion posicion, Object objeto){
        int x = posicion.getX();
        int y = posicion.getY();
        mapa[x][y] = objeto;
    }
    public Object obtenerDePosicion(Posicion posicion){
        int x = posicion.getX();
        int y = posicion.getY();
        return mapa[x][y];
    }
    public Posicion moverObjeto(Posicion pos_ant, Posicion nueva_pos){
        "Como sabe posicion si pude mover el objeto?"
        Object objeto = this.obtenerDePosicion(pos_ant);

        if(objeto == null){
            colocarEnPosicion(nueva_pos, objeto);
            return nueva_pos;
        }
        return pos_ant;
    }
    */