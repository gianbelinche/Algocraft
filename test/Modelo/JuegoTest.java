package Modelo;

import Modelo.Escenario.Tablero;
import Modelo.Materiales.Diamante;
import Modelo.Materiales.Madera;
import Modelo.Materiales.Metal;
import Modelo.Materiales.Piedra;
import org.junit.Test;

public class JuegoTest {

    @Test
    public void testCorrectaInicializacionDeLosMaterialesEnElTablero(){
        Juego juego = new Juego();
        Tablero tableroEsperado = new Tablero(10,10);
        tableroEsperado.colocarEnPosicion(0,0,new Madera());
        tableroEsperado.colocarEnPosicion(0,1,new Madera());
        tableroEsperado.colocarEnPosicion(1,0,new Madera());
        tableroEsperado.colocarEnPosicion(1,1,new Madera());
        tableroEsperado.colocarEnPosicion(5,2,new Piedra());
        tableroEsperado.colocarEnPosicion(6,2,new Piedra());
        tableroEsperado.colocarEnPosicion(7,2,new Piedra());
        tableroEsperado.colocarEnPosicion(1,4,new Metal());
        tableroEsperado.colocarEnPosicion(1,5,new Metal());
        tableroEsperado.colocarEnPosicion(9,8,new Diamante());
        tableroEsperado.colocarEnPosicion(3,7,new Jugador(tableroEsperado));

        assert(juego.tableroEsCorrecto(tableroEsperado));
    }
}