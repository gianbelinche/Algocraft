package Modelo;

public class Juego {
    private Jugador jugador;
    private Tablero tablero;
    private Piedra piedra;
    private Diamante diamante;
    private Madera madera;
    private Metal metal;
    public Juego(){
        int ancho = 10;
        int alto = 10;
        tablero = new Tablero(ancho, alto);
        jugador = new Jugador(tablero);
        piedra = new Piedra();
        madera = new Madera();
        diamante = new Diamante();
        metal = new Metal();
    }
}
