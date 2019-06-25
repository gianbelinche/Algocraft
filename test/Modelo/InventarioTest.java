package Modelo;

import Modelo.Construccion.Constructor;
import Modelo.Herramientas.Herramienta;
import Modelo.Materiales.Diamante;
import Modelo.Materiales.Madera;
import Modelo.Materiales.Metal;
import Modelo.Materiales.Piedra;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InventarioTest {

    private Inventario inventario;

    @Before
    public void setUp(){
        inventario = new Inventario();
    }

    @Test
    public void obtenerMaterialDeInventarioVacioDevuelveCero(){
        assertEquals(0, inventario.obtenerCantidad(new Madera()));
    }

    @Test
    public void guardarHerramientaEnInventarioSeGuardaCorrectamente(){
        Constructor constructor = new Constructor();
        Herramienta herramienta = constructor.crearPicoDeMetal();
        inventario.almacenar(herramienta);
        Herramienta otraHerramienta = constructor.crearPicoDeMetal();
        assertEquals(herramienta, inventario.obtener(otraHerramienta));
    }

    @Test
    public void obtenerCantidadDeInventarioDevuelveLaCantidadCorrecta(){
        int cantidadCorrecta = 2;
        inventario.almacenar(new Piedra());
        inventario.almacenar(new Piedra());
        assertEquals(cantidadCorrecta, inventario.obtenerCantidad(new Piedra()));
    }

    @Test
    public void guardarMaterialEnInventarioSeGuardaCorrectamente(){
        Piedra piedra = new Piedra();
        Piedra otraPiedra = new Piedra();
        inventario.almacenar(piedra);
        assertEquals(piedra, otraPiedra);
    }


    @Test
    public void guardarVariosMaterialesSeGuardanCorrectamente(){
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
    public void guardarVariasHerramientasSeGuardanCorrectamente(){
        Constructor constructor = new Constructor();
        Herramienta picoMetal = constructor.crearPicoDeMetal();
        Herramienta picoPiedra = constructor.crearPicoDePiedra();
        Herramienta picoMadera = constructor.crearPicoDeMadera();

        inventario.almacenar(picoMetal);
        inventario.almacenar(picoPiedra);
        inventario.almacenar(picoMadera);

        Herramienta otroPicoMetal = constructor.crearPicoDeMetal();
        Herramienta otroPicoPiedra = constructor.crearPicoDePiedra();
        Herramienta otroPicoMadera = constructor.crearPicoDeMadera();

        assertEquals(picoMetal, inventario.obtener(otroPicoMetal));
        assertEquals(picoPiedra, inventario.obtener(otroPicoPiedra));
        assertEquals(picoMadera, inventario.obtener(otroPicoMadera));
    }

}

