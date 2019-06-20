package Modelo.Escenario;

public class Tablero {

    private static Tablero elTablero;
    private static int anchoPorDefecto = 10;
    private static int altoPorDefecto = 10;

    private Posicionable[][] mapa;
    private int ancho;
    private int alto;
    private PosicionVacia posicionVacia;

    public static Tablero obtenerTablero(int anchoPasado, int altoPasado){
        if(elTablero == null) elTablero = new Tablero(anchoPasado,altoPasado);
        return elTablero;
    }

    public static Tablero obtenerTablero(){
        if(elTablero == null) elTablero = new Tablero(anchoPorDefecto,altoPorDefecto);
        return elTablero;
    }

    public TableroIterador obtenerIterador(){
        return new TableroIterador(this,ancho,alto);
    }


    private Tablero(int anchoPasado, int altoPasado){
        ancho = anchoPasado;
        alto = altoPasado;
        mapa = new Posicionable[ancho][alto];
        posicionVacia = new PosicionVacia();

        TableroIterador iterador = obtenerIterador();

        while(!iterador.haFinalizado()){
            iterador.colocarEnActual(posicionVacia);
            iterador.avanzar();
        }
    }

    private boolean validarPosicion(int x, int y){
        if(x >= ancho || x < 0) return false;
        if(y >= alto  || y < 0) return false;
        return true;
    }

    public void colocarEnPosicion(int x, int y, Posicionable objetoColocado){
        if(!validarPosicion(x,y)) return;
        mapa[x][y] = objetoColocado;
        Posicion nuevaPosicion = new Posicion(x,y,this);
        objetoColocado.establecerPosicion(nuevaPosicion);
    }

    public void borrarEnPosicion(int x, int y){
        mapa[x][y] = posicionVacia;
    }

    public Posicionable obtenerDePosicion(int x, int y){
        if(!validarPosicion(x,y)) return posicionVacia;
        return mapa[x][y];
    }

    public void mover(int viejaX,int viejaY,int nuevaX, int nuevaY)
    {
        if(!validarPosicion(nuevaX,nuevaY)) return;

        Posicionable objetoMoviendose = obtenerDePosicion(viejaX,viejaY);
        Posicionable casillaDestino = obtenerDePosicion(nuevaX,nuevaY);

        Posicion nuevaPosicion = casillaDestino.actualizarPosicion(viejaX,viejaY,nuevaX,nuevaY);

        borrarEnPosicion(viejaX,viejaY);
        colocarEnPosicion(nuevaPosicion.getX(),nuevaPosicion.getY(),objetoMoviendose);
    }

    public boolean esIgual(Tablero otroTablero){

        for(int i = 0;i < ancho;i++)
        {
            for(int j = 0;j < alto;j++)
            {
                if (!(this.obtenerDePosicion(i,j).esIgual(otroTablero.obtenerDePosicion(i,j)))) return false;
            }
        }
        return true;
    }

}