package Modelo;

import Modelo.Escenario.*;
import Modelo.Materiales.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class JuegoTest {

    Tablero tablero;

    @Test
    public void testCorrectaInicializacionDeLosMaterialesEnElTablero(){

        Juego juego = new Juego();
        tablero = Tablero.obtenerTablero();
        int anchoEsperado = 10;
        int altoEsperado = 10;

        Class[][] tableroEsperado = new Class[anchoEsperado][altoEsperado];

        for(int i = 0;i < anchoEsperado;i++)
        {
            for(int j = 0; j < altoEsperado; j++)
            {
                tableroEsperado[i][j] = PosicionVacia.class;
            }
        }

        tableroEsperado[0][0] = Madera.class;
        tableroEsperado[0][1] = Madera.class;
        tableroEsperado[1][0] = Madera.class;
        tableroEsperado[1][1] = Madera.class;

        tableroEsperado[5][2] = Piedra.class;
        tableroEsperado[6][2] = Piedra.class;
        tableroEsperado[7][2] = Piedra.class;

        tableroEsperado[1][4] = Metal.class;
        tableroEsperado[1][5] = Metal.class;

        tableroEsperado[9][8] = Diamante.class;
        tableroEsperado[3][7] = Jugador.class;


        for(int i = 0;i < anchoEsperado;i++)
        {
            for(int j = 0; j < altoEsperado; j++)
            {
                assertEquals(tableroEsperado[i][j],tablero.obtenerDePosicion(i,j).getClass());
            }
        }


    }
}