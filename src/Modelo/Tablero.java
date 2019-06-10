package Modelo;

public class Tablero {

    private Posicionable [][] mapa;
    private int ancho;
    private int alto;
    private PosicionVacia posicionVacia;

    public Tablero(int anchoPasado, int altoPasado){
        ancho = anchoPasado;
        alto = altoPasado;
        mapa = new Posicionable[ancho][alto];
        posicionVacia = new PosicionVacia();

        for(int i = 0;i < ancho;i++)
        {
            for(int j = 0;j < alto;j++)
            {
                colocarEnPosicion(i,j,posicionVacia);
            }
        }
    }

    public  int estaLibre(int x, int y)
    {
        if(!validarPosicion(x,y)) return 0;
        return obtenerDePosicion(x,y).estaLibre();
    }

    public void colocarEnPosicion(int x, int y, Posicionable objeto){
        if(validarPosicion(x,y)) mapa[x][y] = objeto;
    }

    public void borrarEnPosicion(int x, int y){
        if(validarPosicion(x,y)) mapa[x][y] = posicionVacia;
    }

    private boolean validarPosicion(int x, int y){
        if(x >= ancho || x < 0) return false;
        if(y >= alto  || y < 0) return false;
        return true;
    }

    public Posicionable obtenerDePosicion(int x, int y){

        if(!validarPosicion(x,y)) return posicionVacia;
        return mapa[x][y];
    }


    public int mover(int viejaX,int viejaY,int incrementoX, int incrementoY)
    {
        Posicionable objetoAMover = obtenerDePosicion(viejaX,viejaY);
        int escalaDeMovimiento = estaLibre(viejaX + incrementoX,viejaY + incrementoY);
        int nuevaX = viejaX + incrementoX*escalaDeMovimiento;
        int nuevaY = viejaY + incrementoY*escalaDeMovimiento;

        borrarEnPosicion(viejaX,viejaY);
        colocarEnPosicion(nuevaX,nuevaY,objetoAMover);

        return escalaDeMovimiento;
    }
}