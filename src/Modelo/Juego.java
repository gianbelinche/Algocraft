package Modelo;

import Modelo.Escenario.Tablero;
import Modelo.Escenario.TableroIterador;
import Modelo.Materiales.*;

public class Juego {
    private Jugador jugador;
    private Tablero tablero;

    public Juego(){
        int ancho = 10;
        int largo = 10;
        int alto = 10;
        tablero = Tablero.obtenerTablero(ancho,largo,alto);
        jugador = new Jugador();
        this.inicializarTablero();
    }

    private void inicializarTablero(){
        TableroIterador iterador = tablero.obtenerIterador();

        while(!iterador.haFinalizado()){
            if(iterador.getZ() >= 6){
                iterador.colocarEnActual(new Tierra());
            }
            iterador.avanzar();
        }

        tablero.colocarEnPosicion(0,7,5,new Tierra());
        tablero.colocarEnPosicion(1,7,5,new Tierra());
        tablero.colocarEnPosicion(0,8,5,new Tierra());
        tablero.colocarEnPosicion(1,8,5,new Tierra());

        tablero.borrarEnPosicion(8,7,6);
        tablero.borrarEnPosicion(8,8,6);
        tablero.borrarEnPosicion(8,9,6);
        tablero.borrarEnPosicion(9,7,6);
        tablero.borrarEnPosicion(9,8,6);
        tablero.borrarEnPosicion(9,9,6);

        tablero.colocarEnPosicion(0,0,5,new Madera());
        tablero.colocarEnPosicion(0,1,5,new Madera());
        tablero.colocarEnPosicion(1,0,5,new Madera());
        tablero.colocarEnPosicion(1,1,5,new Madera());

        tablero.colocarEnPosicion(5,2,5,new Piedra());
        tablero.colocarEnPosicion(6,2,5,new Piedra());
        tablero.colocarEnPosicion(7,2,5,new Piedra());

        tablero.colocarEnPosicion(1,4,5,new Metal());
        tablero.colocarEnPosicion(1,5,5,new Metal());

        tablero.colocarEnPosicion(3,7,5,jugador);

    }

    public Jugador obtenerJugador(){
        return jugador;
    }
}
