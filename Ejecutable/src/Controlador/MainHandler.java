package Controlador;

import Vista.CajaMusical;
import Modelo.ElementosJugador.Jugador;
import Vista.Ventana;
import Vista.VentanaJuego.VentanaInventario.InventarioLayout;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
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

            switch (key.getCode()){
                case A:
                    jugador.moverIzquierda();
                    ventana.cambiarImagenJugador(new Image("file:src/Vista/Imagenes/JugadorIzquierda.png"));
                    break;
                case S:
                    jugador.moverAbajo();
                    ventana.cambiarImagenJugador(new Image("file:src/Vista/Imagenes/JugadorAbajo.png"));
                    break;

                case D:
                    jugador.moverDerecha();
                    ventana.cambiarImagenJugador(new Image("file:src/Vista/Imagenes/JugadorDerecha.png"));
                    break;

                case W:
                    jugador.moverArriba();
                    ventana.cambiarImagenJugador(new Image("file:src/Vista/Imagenes/JugadorArriba.png"));
                    break;

                case P:
                    CajaMusical.reproducirMusicaDeHacha();
                    jugador.recoger();
                    break;

                case E:
                    inventario.cambiarVisibilidad();
                    inventario.actualizarHerramientas();
                    inventario.actualizarMateriales();
                    break;

                case H:
                    ventana.mostrarAyuda();
        }
        ventana.actualizarImagen();
    }

}
