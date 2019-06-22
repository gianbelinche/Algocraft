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
        int largoEsperado = 10;
        int altoEsperado  = 10;

        Class[][][] tableroEsperado = new Class[anchoEsperado][largoEsperado][altoEsperado];

        for(int i = 0;i < anchoEsperado;i++){
            for(int j = 0; j < largoEsperado; j++){
                for(int k = 0; k < altoEsperado; k++){
                    tableroEsperado[i][j][k] = PosicionVacia.class;
                }
            }
        }

        tableroEsperado[0][0][0] = Madera.class;
        tableroEsperado[0][1][0] = Madera.class;
        tableroEsperado[1][0][0] = Madera.class;
        tableroEsperado[1][1][0] = Madera.class;

        tableroEsperado[5][2][0] = Piedra.class;
        tableroEsperado[6][2][0] = Piedra.class;
        tableroEsperado[7][2][0] = Piedra.class;

        tableroEsperado[1][4][0] = Metal.class;
        tableroEsperado[1][5][0] = Metal.class;

        tableroEsperado[9][8][0] = Diamante.class;
        tableroEsperado[3][7][0] = Jugador.class;


        for(int i = 0;i < anchoEsperado;i++){
            for(int j = 0; j < largoEsperado; j++){
                for(int k = 0; k < altoEsperado; k++){
                    assertEquals(tableroEsperado[i][j][k],tablero.obtenerDePosicion(i,j,k).getClass());
                }
            }
        }

    }
}