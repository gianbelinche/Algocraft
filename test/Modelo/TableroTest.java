package Modelo;

import Modelo.Construccion.Constructor;
import Modelo.Escenario.*;
import Modelo.Herramientas.Pico;
import Modelo.Materiales.Madera;
import Modelo.Materiales.Piedra;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TableroTest {
    private Tablero tablero;
    private TableroIterador iterador;
    private int alto;
    private int ancho;

    private void resetearTablero(Tablero elTablero, int ancho,int alto){

        TableroIterador iterador = tablero.obtenerIterador();
        while(!iterador.haFinalizado()){
            iterador.borrarEnActual();
            iterador.avanzar();
        }
    }

    @Before
    public void SetUp(){
        alto = 10;
        ancho = 10;
        tablero = Tablero.obtenerTablero(ancho, alto);
        resetearTablero(tablero,ancho,alto);
        iterador = tablero.obtenerIterador();
    }

    @Test
    public void testTableroSeCreaConCeldasVacias(){
        for(int x=0; x<ancho; x++){
            for(int y=0; y<alto; y++){
                assertEquals(tablero.obtenerDePosicion(x,y).getClass(),PosicionVacia.class);
            }
        }
    }

    @Test
    public void testTableroColocarMaterial(){
        int x = 6;
        int y = 3;
        Piedra piedra = new Piedra();
        tablero.colocarEnPosicion(x,y,piedra);
        assertEquals(piedra, tablero.obtenerDePosicion(x,y));
    }

    @Test
    public void testTableroBorrarMaterial(){
        int x = 6;
        int y = 3;
        Piedra piedra = new Piedra();
        tablero.colocarEnPosicion(x,y,piedra);
        tablero.borrarEnPosicion(x,y);
        assertEquals(tablero.obtenerDePosicion(x,y).getClass(),PosicionVacia.class);
    }

    @Test
    public void testTableroColocarJugador(){
        int x = 5;
        int y = 5;
        Jugador jugador = new Jugador();
        tablero.colocarEnPosicion(x,y,jugador);
        assertEquals(jugador, tablero.obtenerDePosicion(x,y));
    }

    @Test
    public void testTableroBorrarJugador(){
        int x = 5;
        int y = 5;
        Jugador jugador = new Jugador();
        tablero.colocarEnPosicion(x,y,jugador);
        tablero.borrarEnPosicion(x,y);
        assertEquals(tablero.obtenerDePosicion(x,y).getClass(),PosicionVacia.class);
    }

    @Test
    public void testTableroJugadorSeMueveHaciaLaDerechaYDejaUnaCasillaLibre(){
        int x = 5;
        int y = 5;
        Jugador jugador = new Jugador();
        tablero.colocarEnPosicion(x,y,jugador);
        jugador.moverDerecha();

        assertEquals(tablero.obtenerDePosicion(x,y).getClass(),PosicionVacia.class);
    }

    @Test
    public void testTableroJugadorSeMueveHaciaLaIzquierdaYDejaUnaCasillaLibre(){
        int x = 5;
        int y = 5;
        Jugador jugador = new Jugador();
        tablero.colocarEnPosicion(x,y,jugador);
        jugador.moverIzquierda();

        assertEquals(tablero.obtenerDePosicion(x,y).getClass(),PosicionVacia.class);
    }

    @Test
    public void testTableroJugadorSeMueveHaciaArribaYDejaUnaCasillaLibre(){
        int x = 5;
        int y = 5;
        Jugador jugador = new Jugador();
        tablero.colocarEnPosicion(x,y,jugador);
        jugador.moverArriba();

        assertEquals(tablero.obtenerDePosicion(x,y).getClass(),PosicionVacia.class);
    }


    @Test
    public void testTableroJugadorSeMueveHaciaAbajoYDejaUnaCasillaLibre(){
        int x = 5;
        int y = 5;
        Jugador jugador = new Jugador();
        tablero.colocarEnPosicion(x,y,jugador);
        jugador.moverAbajo();

        assertEquals(tablero.obtenerDePosicion(x,y).getClass(),PosicionVacia.class);
    }


    @Test
    public void testTableroMoverJugadorFueraDelBordeNoAlteraPosicion(){
        int x = 5;
        int y = 5;
        Jugador jugador = new Jugador();
        tablero.colocarEnPosicion(x,y,jugador);

        for(int i = 0;i <100;i++){
            jugador.moverDerecha();
        }

        assertEquals(jugador, tablero.obtenerDePosicion(ancho - 1,y));
    }

    @Test
    public void testTableroMoverJugadorContraMaterialNoAlteraSuPosicion(){
        int x = 5;
        int y = 5;
        Jugador jugador = new Jugador();
        tablero.colocarEnPosicion(x,y,jugador);
        Piedra piedra = new Piedra();
        tablero.colocarEnPosicion(x + 1,y,piedra);

        jugador.moverDerecha();

        assertEquals(jugador, tablero.obtenerDePosicion(x,y));
    }

    @Test
    public void testTableroAlRecolectarseUnMaterialSeEliminaDelMapa(){
        int x = 5;
        int y = 5;
        Piedra piedra = new Piedra();
        tablero.colocarEnPosicion(x,y,piedra);

        Constructor constructor = new Constructor();
        Pico pico = constructor.crearPicoDeMetal();
        pico.recoger(piedra);
        pico.recoger(piedra);
        pico.recoger(piedra);

        assertEquals(tablero.obtenerDePosicion(x,y).getClass(),PosicionVacia.class);
    }

    @Test
    public void testTableroIteradorRecorreTodoElTablero(){
        int xEsperada = 0;
        int yEsperada = alto;

        while(!iterador.haFinalizado()){
            iterador.avanzar();
        }

        assertEquals(xEsperada, iterador.getX());
        assertEquals(yEsperada,iterador.getY());
    }

    @Test
    public void testTableroIteradorColocaObjetoCorrectamente(){

        Madera objetoAcolocar = new Madera();
        int x = 3;
        iterador.avanzar();
        iterador.avanzar();
        iterador.avanzar();
        iterador.colocarEnActual(objetoAcolocar);

        assertEquals(tablero.obtenerDePosicion(x,0),objetoAcolocar);
    }

    @Test
    public void testTableroIteradorColocaObjetoCorrectamenteVolumen(){

        Madera objetoAcolocar = new Madera();

        while(!iterador.haFinalizado()){
            iterador.colocarEnActual(objetoAcolocar);
            iterador.avanzar();
        }

        for(int x=0; x<ancho; x++){
            for(int y=0; y<alto; y++){
                assertEquals(tablero.obtenerDePosicion(x,y),objetoAcolocar);
            }
        }
    }

    @Test
    public void testTableroIteradorBorraObjetoCorrectamente(){

        Madera objetoAcolocar = new Madera();
        int x = 3;
        iterador.avanzar();
        iterador.avanzar();
        iterador.avanzar();
        iterador.colocarEnActual(objetoAcolocar);
        iterador.borrarEnActual();

        assertEquals(tablero.obtenerDePosicion(x,0).getClass(),PosicionVacia.class);
    }

    @Test
    public void testTableroIteradorBorraObjetoCorrectamenteVolumen(){

        Madera objetoAcolocar = new Madera();

        for(int x=0; x<ancho; x++){
            for(int y=0; y<alto; y++){
                tablero.colocarEnPosicion(x,y,objetoAcolocar);
            }
        }

        while(!iterador.haFinalizado()){
            iterador.borrarEnActual();
            iterador.avanzar();
        }

        for(int x=0; x<ancho; x++){
            for(int y=0; y<alto; y++){
                assertEquals(tablero.obtenerDePosicion(x,y).getClass(),PosicionVacia.class);
            }
        }
    }

    @Test
    public void testTableroIteradorRetornaObjetoActualCorrectamente(){

        int x = 2;
        int y = 6;
        Madera objetoAcolocar = new Madera();
        tablero.colocarEnPosicion(x,y,objetoAcolocar);

        for(int i = 0; i < (y*ancho + x);i++) iterador.avanzar();

        assertEquals(objetoAcolocar,iterador.verActual());
    }

    @Test
    public void testTableroIteradorRetornaObjetoActualCorrectamenteVolumen(){

        for(int x=0; x<ancho; x++){
            for(int y=0; y<alto; y++){
                tablero.colocarEnPosicion(x,y,new Piedra());
            }
        }

        int x = 0;
        int y = 0;

        while(!iterador.haFinalizado()){
            assertEquals(tablero.obtenerDePosicion(x,y),iterador.verActual());
            iterador.avanzar();

            x++;
            if(x == ancho){
                y++;
                x = 0;
            }
        }
    }
}