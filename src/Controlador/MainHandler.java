package Controlador;

import Modelo.Jugador;
import Vista.Ventana;
import Vista.VentanaJuego.VentanaInventario.InventarioLayout;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class MainHandler implements EventHandler<KeyEvent>{

    private InventarioLayout inventario;
    private Jugador jugador;
    private Ventana ventana;

    public MainHandler(Jugador jugador, Ventana vemtana, InventarioLayout inventarioLayout){
        this.jugador = jugador;
        this.ventana = vemtana;
        this.inventario = inventarioLayout;
    }

    public void handle(KeyEvent key){
        if (key.getCode() == KeyCode.A ) {
            jugador.moverIzquierda();
            ventana.cambiarImagenJugador(new Image("file:src/Vista/Imagenes/JugadorIzquierda.png"));
        }
        else if (key.getCode() == KeyCode.S ){
            jugador.moverAbajo();
            ventana.cambiarImagenJugador(new Image("file:src/Vista/Imagenes/JugadorAbajo.png"));
        }
        else if (key.getCode() == KeyCode.D ){
            jugador.moverDerecha();
            ventana.cambiarImagenJugador(new Image("file:src/Vista/Imagenes/JugadorDerecha.png"));
        }
        else if (key.getCode() == KeyCode.W ){
            jugador.moverArriba();
            ventana.cambiarImagenJugador(new Image("file:src/Vista/Imagenes/JugadorArriba.png"));
        }
        else if (key.getCode() == KeyCode.P) {
            jugador.recoger();
        }
        else if (key.getCode() == KeyCode.E) {
            inventario.cambiarVisibilidad();
            inventario.actualizarHerramientas();
            inventario.actualizarMateriales();
        }
        ventana.actualizarImagen();
    }

}
