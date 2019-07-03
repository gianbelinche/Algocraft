package Modelo;

import Modelo.ElementosJugador.Jugador;
import Modelo.Construccion.Constructor;
import Modelo.Escenario.*;
import Modelo.Herramientas.Pico;
import Modelo.Inventario.Inventario;
import Modelo.Materiales.Madera;
import Modelo.Materiales.Piedra;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TableroTest {
    private Tablero tablero;
    private TableroIterador iterador;
    private int largo;
    private int ancho;
    private int alto;

    private void resetearTablero(){

        TableroIterador iterador = tablero.obtenerIterador();
        while(!iterador.haFinalizado()){
            iterador.borrarEnActual();
            iterador.avanzar();
        }
    }

    @Before
    public void SetUp(){
        largo = 10;
        ancho = 10;
        alto  = 10;
        tablero = Tablero.crearTablero(ancho, largo,alto);
        resetearTablero();
        iterador = tablero.obtenerIterador();
    }

    @Test
    public void testTableroSeCreaConCeldasVacias(){
        for(int x=0; x<ancho; x++){
            for(int y=0; y<largo; y++){
                for(int z = 0; z < alto;z++){
                    assertEquals(tablero.obtenerDePosicion(x,y,z).getClass(),PosicionVacia.class);
                }
            }
        }
    }

    @Test
    public void testTableroColocarMaterial(){
        int x = 6;
        int y = 3;
        int z = 0;
        Piedra piedra = new Piedra();
        tablero.colocarEnPosicion(x,y,z,piedra);
        assertEquals(piedra, tablero.obtenerDePosicion(x,y,z));
    }

    @Test
    public void testTableroBorrarMaterial(){
        int x = 6;
        int y = 3;
        int z = 0;
        Piedra piedra = new Piedra();
        tablero.colocarEnPosicion(x,y,z,piedra);
        tablero.borrarEnPosicion(x,y,z);
        assertEquals(tablero.obtenerDePosicion(x,y,z).getClass(),PosicionVacia.class);
    }

    @Test
    public void testTableroColocarJugador(){
        int x = 5;
        int y = 5;
        int z = 0;
        Inventario inventario = new Inventario();
        Jugador jugador = new Jugador(inventario);
        tablero.colocarEnPosicion(x,y,z,jugador);
        assertEquals(jugador, tablero.obtenerDePosicion(x,y,z));
    }

    @Test
    public void testTableroBorrarJugador(){
        int x = 5;
        int y = 5;
        int z = 0;
        Inventario inventario = new Inventario();
        Jugador jugador = new Jugador(inventario);
        tablero.colocarEnPosicion(x,y,z,jugador);
        tablero.borrarEnPosicion(x,y,z);
        assertEquals(tablero.obtenerDePosicion(x,y,z).getClass(),PosicionVacia.class);
    }

    @Test
    public void testTableroJugadorSeMueveHaciaLaDerechaYDejaUnaCasillaLibre(){
        int x = 5;
        int y = 5;
        int z = 0;
        Inventario inventario = new Inventario();
        Jugador jugador = new Jugador(inventario);
        tablero.colocarEnPosicion(x,y,z,jugador);
        jugador.moverDerecha();

        assertEquals(tablero.obtenerDePosicion(x,y,z).getClass(),PosicionVacia.class);
    }

    @Test
    public void testTableroJugadorSeMueveHaciaLaIzquierdaYDejaUnaCasillaLibre(){
        int x = 5;
        int y = 5;
        int z = 0;
        Inventario inventario = new Inventario();
        Jugador jugador = new Jugador(inventario);
        tablero.colocarEnPosicion(x,y,z,jugador);
        jugador.moverIzquierda();

        assertEquals(tablero.obtenerDePosicion(x,y,z).getClass(),PosicionVacia.class);
    }

    @Test
    public void testTableroJugadorSeMueveHaciaArribaYDejaUnaCasillaLibre(){
        int x = 5;
        int y = 5;
        int z = 0;
        Inventario inventario = new Inventario();
        Jugador jugador = new Jugador(inventario);
        tablero.colocarEnPosicion(x,y,z,jugador);
        jugador.moverArriba();

        assertEquals(tablero.obtenerDePosicion(x,y,z).getClass(),PosicionVacia.class);
    }


    @Test
    public void testTableroJugadorSeMueveHaciaAbajoYDejaUnaCasillaLibre(){
        int x = 5;
        int y = 5;
        int z = 0;
        Inventario inventario = new Inventario();
        Jugador jugador = new Jugador(inventario);
        tablero.colocarEnPosicion(x,y,z,jugador);
        jugador.moverAbajo();

        assertEquals(tablero.obtenerDePosicion(x,y,z).getClass(),PosicionVacia.class);
    }


    @Test
    public void testTableroMoverJugadorFueraDelBordeNoAlteraPosicion(){
        int x = 5;
        int y = 5;
        int z = 0;
        Inventario inventario = new Inventario();
        Jugador jugador = new Jugador(inventario);
        tablero.colocarEnPosicion(x,y,z,jugador);

        for(int i = 0;i <100;i++){
            jugador.moverDerecha();
        }

        assertEquals(jugador, tablero.obtenerDePosicion(ancho - 1,y,z));
    }

    @Test
    public void testTableroMoverJugadorContraMaterialNoAlteraSuPosicion(){
        int x = 5;
        int y = 5;
        int z = 0;
        Inventario inventario = new Inventario();
        Jugador jugador = new Jugador(inventario);
        tablero.colocarEnPosicion(x,y,z,jugador);
        Piedra piedra = new Piedra();
        tablero.colocarEnPosicion(x + 1,y,0,piedra);

        jugador.moverDerecha();

        assertEquals(jugador, tablero.obtenerDePosicion(x,y,z));
    }

    @Test
    public void testTableroAlRecolectarseUnMaterialSeEliminaDelMapa(){
        int x = 5;
        int y = 5;
        int z = 0;
        Piedra piedra = new Piedra();
        tablero.colocarEnPosicion(x,y,z,piedra);

        Constructor constructor = new Constructor();
        Pico pico = constructor.crearPicoDeMetal();
        pico.recoger(piedra);
        pico.recoger(piedra);
        pico.recoger(piedra);

        assertEquals(tablero.obtenerDePosicion(x,y,z).getClass(),PosicionVacia.class);
    }

    @Test
    public void testTableroIteradorRecorreTodoElTablero(){
        int xEsperada = 0;
        int yEsperada = largo;
        int zEsperada = alto - 1;

        while(!iterador.haFinalizado()){
            iterador.avanzar();
        }

        assertEquals(xEsperada,iterador.getX());
        assertEquals(yEsperada,iterador.getY());
        assertEquals(zEsperada,iterador.getZ());
    }

    @Test
    public void testTableroIteradorColocaObjetoCorrectamente(){

        Madera objetoAcolocar = new Madera();
        int x = 3;
        iterador.avanzar();
        iterador.avanzar();
        iterador.avanzar();
        iterador.colocarEnActual(objetoAcolocar);

        assertEquals(tablero.obtenerDePosicion(x,0,alto - 1),objetoAcolocar);
    }

    @Test
    public void testTableroIteradorColocaObjetoCorrectamenteVolumen(){

        Madera objetoAcolocar = new Madera();

        while(!iterador.haFinalizado()){
            iterador.colocarEnActual(objetoAcolocar);
            iterador.avanzar();
        }

        for(int x=0; x<ancho; x++){
            for(int y=0; y<largo; y++){
                for(int z=0; z<alto; z++){
                    assertEquals(tablero.obtenerDePosicion(x,y,z),objetoAcolocar);
                }
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

        assertEquals(tablero.obtenerDePosicion(x,0,0).getClass(),PosicionVacia.class);
    }

    @Test
    public void testTableroIteradorBorraObjetoCorrectamenteVolumen(){

        Madera objetoAcolocar = new Madera();

        for(int x=0; x<ancho; x++){
            for(int y=0; y<largo; y++){
                for(int z=0; z<alto; z++){
                tablero.colocarEnPosicion(x,y,z,objetoAcolocar);
                }
            }
        }

        while(!iterador.haFinalizado()){
            iterador.borrarEnActual();
            iterador.avanzar();
        }

        for(int x=0; x<ancho; x++){
            for(int y=0; y<largo; y++){
                for(int z=0; z<alto; z++){
                assertEquals(tablero.obtenerDePosicion(x,y,z).getClass(),PosicionVacia.class);
                }
            }
        }
    }

    @Test
    public void testTableroIteradorRetornaObjetoActualCorrectamente(){

        int x = 2;
        int y = 0;
        int z = alto - 1;

        Madera objetoAcolocar = new Madera();
        tablero.colocarEnPosicion(x,y,z,objetoAcolocar);

        iterador.avanzar();
        iterador.avanzar();

        assertEquals(objetoAcolocar,iterador.verActual());
    }
    
    @Test
    public void testTableroIteradorRetornaObjetoActualCorrectamenteVolumen(){

        for(int x=0; x<ancho; x++){
            for(int y=0; y<largo; y++){
                for(int z=0; z<alto; z++){
                tablero.colocarEnPosicion(x,y,z,new Piedra());
                }
            }
        }

        int x = 0;
        int y = 0;
        int z = 0;

        while(!iterador.haFinalizado()){
            assertEquals(tablero.obtenerDePosicion(x,y,z),iterador.verActual());
            iterador.avanzar();

            x++;
            if(x == ancho){
                x = 0;y++;
            }
            if(y == largo){
                x = 0;y = 0;z++;
            }
        }
    }

}