package Modelo;

import Modelo.Escenario.Tablero;
import Modelo.Materiales.Diamante;
import Modelo.Materiales.Madera;
import Modelo.Materiales.Metal;
import Modelo.Materiales.Piedra;

public class Juego {
    private Jugador jugador;
    private Tablero tablero;
    private Piedra piedra;
    private Diamante diamante;
    private Madera madera;
    private Metal metal;
    public Juego(){
        int ancho = 10;
        int largo = 10;
        int alto = 10;
        tablero = Tablero.obtenerTablero(ancho,largo,alto);
        jugador = new Jugador();
        piedra = new Piedra();
        madera = new Madera();
        diamante = new Diamante();
        metal = new Metal();
        this.inicializarTablero();
    }

    private void inicializarTablero(){

        tablero.colocarEnPosicion(0,0,0,new Madera());
        tablero.colocarEnPosicion(0,1,0,new Madera());
        tablero.colocarEnPosicion(1,0,0,new Madera());
        tablero.colocarEnPosicion(1,1,0,new Madera());
        tablero.colocarEnPosicion(5,2,0,new Piedra());
        tablero.colocarEnPosicion(6,2,0,new Piedra());
        tablero.colocarEnPosicion(7,2,0,new Piedra());
        tablero.colocarEnPosicion(1,4,0,new Metal());
        tablero.colocarEnPosicion(1,5,0,new Metal());
        tablero.colocarEnPosicion(9,8,0,new Diamante());
        tablero.colocarEnPosicion(3,7,0,jugador);

    }

    public Jugador obtenerJugador(){
        return jugador;
    }
}
