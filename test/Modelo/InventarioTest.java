package Modelo;

import Modelo.Construccion.Constructor;
import Modelo.Herramientas.Herramienta;
import Modelo.Inventario.Inventario;
import Modelo.Materiales.Diamante;
import Modelo.Materiales.Madera;
import Modelo.Materiales.Metal;
import Modelo.Materiales.Piedra;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InventarioTest {

    private Inventario inventario;
    private Constructor constructor;

    @Before
    public void setUp(){
        inventario = new Inventario();
        constructor = new Constructor();
    }

    @Test
    public void testObtenerMaterialDeInventarioVacioDevuelveCero(){
        assertEquals(0, inventario.obtenerCantidad(new Madera()));
    }

    @Test
    public void testGuardarHerramientaEnInventarioSeGuardaCorrectamente(){
        Herramienta herramienta = constructor.crearPicoDeMetal();
        inventario.almacenar(herramienta);
        Herramienta otraHerramienta = constructor.crearPicoDeMetal();
        assertEquals(herramienta, inventario.obtener(otraHerramienta));
    }

    @Test
    public void testObtenerCantidadDeInventarioDevuelveLaCantidadCorrecta(){
        int cantidadCorrecta = 2;
        inventario.almacenar(new Piedra());
        inventario.almacenar(new Piedra());
        assertEquals(cantidadCorrecta, inventario.obtenerCantidad(new Piedra()));
    }

    @Test
    public void testGuardarMaterialEnInventarioSeGuardaCorrectamente(){
        Piedra piedra = new Piedra();
        Piedra otraPiedra = new Piedra();
        inventario.almacenar(piedra);
        assertEquals(piedra, otraPiedra);
    }


    @Test
    public void testGuardarVariosMaterialesSeGuardanCorrectamente(){
        Piedra piedra = new Piedra();
        Madera madera = new Madera();
        Diamante diamante = new Diamante();
        Metal metal = new Metal();
        inventario.almacenar(piedra);
        inventario.almacenar(madera);
        inventario.almacenar(diamante);
        inventario.almacenar(metal);
        Piedra  otraPiedra = new Piedra();
        Madera otraMadera = new Madera();
        Diamante otroDiamante = new Diamante();
        Metal otroMetal = new Metal();
        assertEquals(piedra, inventario.obtener(otraPiedra));
        assertEquals(madera, inventario.obtener(otraMadera));
        assertEquals(diamante, inventario.obtener(otroDiamante));
        assertEquals(metal, inventario.obtener(otroMetal));
    }

    @Test
    public void testGuardarVariasHerramientasSeGuardanCorrectamente(){
        Herramienta picoMetal = constructor.crearPicoDeMetal();
        Herramienta picoPiedra = constructor.crearPicoDePiedra();
        Herramienta picoMadera = constructor.crearPicoDeMadera();
        Herramienta picoFino = constructor.crearPicoDePiedraRefinada();

        inventario.almacenar(picoMetal);
        inventario.almacenar(picoPiedra);
        inventario.almacenar(picoMadera);
        inventario.almacenar(picoFino);

        Herramienta otroPicoMetal = constructor.crearPicoDeMetal();
        Herramienta otroPicoPiedra = constructor.crearPicoDePiedra();
        Herramienta otroPicoMadera = constructor.crearPicoDeMadera();
        Herramienta otroPicoFino = constructor.crearPicoDePiedraRefinada();

        assertEquals(picoMetal, inventario.obtener(otroPicoMetal));
        assertEquals(picoPiedra, inventario.obtener(otroPicoPiedra));
        assertEquals(picoMadera, inventario.obtener(otroPicoMadera));
        assertEquals(picoFino, inventario.obtener(otroPicoFino));
    }

    @Test
    public void testGuardarVariasHerramientasYObtenerCantidadDevuelveCantidadCorrecta(){
        int cantidadHachaMadera = 2;
        int cantidadPicoPiedra = 3;
        int cantidadPicoFino = 1;
        int cantidadHachaMetal = 0;

        inventario.almacenar(constructor.crearHachaDeMadera());
        inventario.almacenar(constructor.crearHachaDeMadera());
        inventario.almacenar(constructor.crearPicoDePiedra());
        inventario.almacenar(constructor.crearPicoDePiedra());
        inventario.almacenar(constructor.crearPicoDePiedra());
        inventario.almacenar(constructor.crearPicoDePiedraRefinada());

        assertEquals(cantidadHachaMadera, inventario.obtenerCantidad(constructor.crearHachaDeMadera()));
        assertEquals(cantidadPicoPiedra, inventario.obtenerCantidad(constructor.crearPicoDePiedra()));
        assertEquals(cantidadPicoFino, inventario.obtenerCantidad(constructor.crearPicoDePiedraRefinada()));
        assertEquals(cantidadHachaMetal, inventario.obtenerCantidad(constructor.crearHachaDeMetal()));

    }

    @Test
    public void testGuardarVariosMaterialesYObtenerCantidadDevuelveCantidadCorrecta(){

        int cantidadMadera = 2;
        int cantidadDiamante = 1;
        int cantidadMetal = 3;
        int cantidadPiedra = 0;

        inventario.almacenar(new Madera());
        inventario.almacenar(new Madera());
        inventario.almacenar(new Diamante());
        inventario.almacenar(new Metal());
        inventario.almacenar(new Metal());
        inventario.almacenar(new Metal());

        assertEquals(cantidadMadera, inventario.obtenerCantidad(new Madera()));
        assertEquals(cantidadDiamante, inventario.obtenerCantidad(new Diamante()));
        assertEquals(cantidadMetal, inventario.obtenerCantidad(new Metal()));
        assertEquals(cantidadPiedra, inventario.obtenerCantidad(new Piedra()));
    }

}

