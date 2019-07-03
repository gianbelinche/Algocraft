package Modelo;

import Modelo.Herramientas.Pico;
import Modelo.ElementosJugador.*;
import Modelo.ElementosJugador.Jugador;
import Modelo.Construccion.Constructor;
import Modelo.Escenario.Tablero;
import Modelo.Escenario.TableroIterador;
import Modelo.Herramientas.Hacha;
import Modelo.Herramientas.Herramienta;
import Modelo.Inventario.Almacenable;
import Modelo.Inventario.Inventario;
import Modelo.Materiales.Madera;
import Modelo.Materiales.Piedra;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class JugadorTest {

    private Constructor constructor;
    private Jugador jugador;
    private Herramienta herramienta;
    private Tablero tablero;
    private int x;
    private int y;
    private int z;
    private Direccion direccion;


    private void resetearTablero(){

        TableroIterador iterador = tablero.obtenerIterador();
        while(!iterador.haFinalizado()){
            iterador.borrarEnActual();
            iterador.avanzar();
        }
    }

    @Before
    public void setUp(){
        Inventario inventario = new Inventario();
        constructor = new Constructor();
        jugador = new Jugador(inventario);
        herramienta = jugador.herramientaEquipada();
        direccion = jugador.getDireccion();
        tablero = Tablero.obtenerTablero();
        resetearTablero();
        x = 6;
        y = 6;
        z = 0;
        tablero.colocarEnPosicion(x,y,z,jugador);
    }

    @Test
    public void testCrearJugadorPoseeHachaComoHerramientaInicial(){
        assertTrue(herramienta instanceof Hacha);
    }

    @Test
    public void testCrearJugadorPoseeHachaDeDurabilidadCorrecta(){
        int durabilidadDeseada = 100;
        int durabilidadInicial = herramienta.durabilidad();

        assertEquals(durabilidadDeseada, durabilidadInicial);
    }

    @Test
    public void testCrearJugadorPoseeHachaConDesgasteLineal(){
        int durabilidadInicial = herramienta.durabilidad();
        int repeticiones = 20;
        int desgasteFinal = repeticiones*herramienta.fuerza();

        for(int i=0; i<repeticiones; i++){
            herramienta.recoger(new Madera());
        }

        assertEquals(durabilidadInicial-desgasteFinal, herramienta.durabilidad());
    }

    @Test
    public void testCrearJugadorPoseeHachaConFuerzaCorrecta(){
        int fuerzaDeseada = 2;
        int fuerzaHerramienta = herramienta.fuerza();

        assertEquals(fuerzaDeseada, fuerzaHerramienta);
    }


    @Test
    public void testJugadorSeCreaConDireccionAbajo(){
        assertTrue(direccion instanceof Abajo);
    }

    @Test
    public void testJugadorSeMueveHaciaAbajoYNoCambiaSuDireccion(){
        jugador.moverAbajo();
        assertTrue(jugador.getDireccion() instanceof Abajo);
    }


    @Test
    public void testJugadorSeMueveHaciaLaDerechaYCambiaSuDireccion(){
        jugador.moverDerecha();
        assertTrue(jugador.getDireccion() instanceof Derecha);
    }

    @Test
    public void testJugadorSeMueveHaciaLaIzquierdaYCambiaSuDireccion(){
        jugador.moverIzquierda();
        assertTrue(jugador.getDireccion() instanceof Izquierda);
    }

    @Test
    public void testJugadorSeMueveHaciaArribaYCambiaSuDireccion(){
        jugador.moverArriba();
        assertTrue(jugador.getDireccion() instanceof Arriba);
    }

    @Test
    public void testJugadorSeMueveHaciaLaDerechaYAumentaSuX(){
        jugador.moverDerecha();
        assertEquals(jugador, tablero.obtenerDePosicion(x + 1,y,z));
    }

    @Test
    public void testJugadorSeMueveHaciaLaIzquierdaYDisminuyeSuX(){

        jugador.moverIzquierda();
        assertEquals(jugador, tablero.obtenerDePosicion(x - 1,y,z));
    }



    @Test
    public void testJugadorSeMueveHaciAbajoYAumentaSuY(){

        jugador.moverAbajo();
        assertEquals(jugador, tablero.obtenerDePosicion(x,y + 1,z));
    }

    @Test
    public void testJugadorSeMueveHaciaArribaYDisminuyeSuY(){

        jugador.moverArriba();
        assertEquals(jugador, tablero.obtenerDePosicion(x,y - 1,z));
    }

    @Test
    public void testJugadorMoverCambiaDireccionPeroNoPosicionAlChocarConPosicionable(){
        int xMaterial = x;
        int yMaterial = y-1;
        int zMaterial = z;
        tablero.colocarEnPosicion(xMaterial,yMaterial,zMaterial,new Madera());
        jugador.moverArriba();
        assertEquals(jugador, tablero.obtenerDePosicion(x,y,z));
        assertTrue(jugador.getDireccion() instanceof Arriba);
    }

    @Test
    public void testJugadorRecogeMaderaConHachaYSeGuardaEnInventario(){
        jugador.equipar(constructor.crearHachaDeMadera());
        Madera madera = new Madera();
        int xMaterial = x;
        int yMaterial = y+1; //Direccion de jugador: Abajo
        int zMaterial = z;
        tablero.colocarEnPosicion(xMaterial,yMaterial,zMaterial,madera);
        Almacenable maderaRecogida;
        jugador.recoger();
        jugador.recoger();
        jugador.recoger();
        jugador.recoger();
        jugador.recoger();
        Madera otraMadera = new Madera();
        maderaRecogida = jugador.obtenerDeInventario(otraMadera);

        assertEquals(madera, maderaRecogida);
    }

    @Test
    public void testJugadorUsaHachaContraPiedraYSeDesgastaElHacha(){
        Hacha hacha = constructor.crearHachaDePiedra();
        int durabilidadInicial = hacha.durabilidad();
        jugador.guardarEnInventario(hacha);
        jugador.equipar(hacha);
        Piedra piedra = new Piedra();
        int xMaterial = x;
        int yMaterial = y+1; //Direccion de jugador: Abajo
        int zMaterial = z;
        tablero.colocarEnPosicion(xMaterial,yMaterial,zMaterial,piedra);
        jugador.recoger();
        jugador.recoger();
        jugador.recoger();
        assert(hacha.durabilidad() < durabilidadInicial);
    }

    @Test
    public void testJugadorUsaPicoContraMaderaYSeDesgastaElPico(){
        Pico pico = constructor.crearPicoDePiedra();
        int durabilidadInicial = pico.durabilidad();
        jugador.guardarEnInventario(pico);
        jugador.equipar(pico);
        Madera madera = new Madera();
        int xMaterial = x;
        int yMaterial = y+1; //Direccion de jugador: Abajo
        int zMaterial = z;
        tablero.colocarEnPosicion(xMaterial,yMaterial,zMaterial,madera);
        jugador.recoger();
        jugador.recoger();
        jugador.recoger();
        assert(pico.durabilidad() < durabilidadInicial);
    }

    @Test
    public void testJugadorObtenerCantidadDeInventarioVacioDevuelveCero(){
        Madera madera = new Madera();
        assertEquals(jugador.obtenerCantidadDeInventario(madera), 0);
    }
}