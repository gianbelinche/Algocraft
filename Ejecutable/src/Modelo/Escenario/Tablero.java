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
    private PosicionOcupada posicionOcupada;

    public static Tablero crearTablero(int anchoPasado, int largoPasado,int altoPasado){
        elTablero = new Tablero(anchoPasado,largoPasado,altoPasado);
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
        posicionOcupada = new PosicionOcupada();

        TableroIterador iterador = obtenerIterador();

        while(!iterador.haFinalizado()){
            iterador.colocarEnActual(posicionVacia);
            iterador.avanzar();
        }
    }


    public void colocarEnPosicion(int x, int y,int z, Posicionable objetoColocado){
        try{
            mapa[x][y][z] = objetoColocado;
            Posicion nuevaPosicion = new Posicion(x,y,z,this);
            objetoColocado.establecerPosicion(nuevaPosicion);
        }catch(ArrayIndexOutOfBoundsException e){}

    }

    public void borrarEnPosicion(int x, int y,int z){
        try{
            mapa[x][y][z] = posicionVacia;
        }
        catch (ArrayIndexOutOfBoundsException e){}
    }

    public Posicionable obtenerDePosicion(int x, int y,int z){
        try{
            return mapa[x][y][z];
        }
        catch (ArrayIndexOutOfBoundsException e){
            return posicionOcupada;
        }

    }

    public void mover(int viejaX,int viejaY,int viejaZ,int nuevaX, int nuevaY,int nuevaZ)
    {
        Posicionable objetoMoviendose = obtenerDePosicion(viejaX,viejaY,viejaZ);
        Posicionable casillaDestino = obtenerDePosicion(nuevaX,nuevaY,nuevaZ);

        Posicion nuevaPosicion = casillaDestino.actualizarPosicion(viejaX,viejaY,viejaZ,nuevaX,nuevaY,nuevaZ);

        borrarEnPosicion(viejaX,viejaY,viejaZ);
        colocarEnPosicion(nuevaPosicion.getX(),nuevaPosicion.getY(),nuevaPosicion.getZ(),objetoMoviendose);
    }
}