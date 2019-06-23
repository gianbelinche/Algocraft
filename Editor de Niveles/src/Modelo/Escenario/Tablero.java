package Modelo.Escenario;

public class Tablero {

    private static Tablero elTablero;
    private static int anchoPorDefecto = 10;
    private static int largoPorDefecto  = 10;
    private static int altoPorDefecto = 10;

    private Posicionable[][][] mapa;
    private int ancho;
    private int largo;
    private int alto;

    private PosicionVacia posicionVacia;

    public static Tablero obtenerTablero(int anchoPasado, int largoPasado,int altoPasado){
        if(elTablero == null) elTablero = new Tablero(anchoPasado,largoPasado,altoPasado);
        return elTablero;
    }

    public static Tablero obtenerTablero(){
        if(elTablero == null) elTablero = new Tablero(anchoPorDefecto,largoPorDefecto,altoPorDefecto);
        return elTablero;
    }

    public TableroIterador obtenerIterador(){
        return new TableroIterador(this,ancho,largo,alto);
    }


    private Tablero(int anchoPasado, int largoPasado,int altoPasado){
        ancho = anchoPasado;
        largo = largoPasado;
        alto =  altoPasado;

        mapa = new Posicionable[ancho][largo][alto];
        posicionVacia = new PosicionVacia();

        TableroIterador iterador = obtenerIterador();

        while(!iterador.haFinalizado()){
            iterador.colocarEnActual(posicionVacia);
            iterador.avanzar();
        }
    }

    private boolean validarPosicion(int x, int y,int z){
        if(x >= ancho || x < 0) return false;
        if(y >= largo || y < 0) return false;
        if(z >= alto  || z < 0) return false;
        return true;
    }

    public void colocarEnPosicion(int x, int y,int z, Posicionable objetoColocado){
        if(!validarPosicion(x,y,z)) return;
        mapa[x][y][z] = objetoColocado;
        Posicion nuevaPosicion = new Posicion(x,y,z,this);
        objetoColocado.establecerPosicion(nuevaPosicion);
    }

    public void borrarEnPosicion(int x, int y,int z){
        mapa[x][y][z] = posicionVacia;
    }

    public Posicionable obtenerDePosicion(int x, int y,int z){
        if(!validarPosicion(x,y,z)) return posicionVacia;
        return mapa[x][y][z];
    }

}