package Modelo;

import Modelo.Construccion.Constructor;
import Modelo.Herramientas.Herramienta;
import Modelo.Materiales.Diamante;
import Modelo.Materiales.Madera;
import Modelo.Materiales.Metal;
import Modelo.Materiales.Piedra;
import org.junit.Test;

import static org.junit.Assert.*;

public class InventarioTest {
    private Inventario inventario;
    private int ancho = 9;
    private int alto = 3;




    @Test
    public void obtenerMaterialDeInventarioVacioDevuelveCero(){
        inventario = new Inventario();
        assertEquals(0, inventario.obtenerCantidad(new Madera()));
    }
    @Test
    public void guardarHerramientaEnInventarioSeGuardaCorrectamente(){
        inventario = new Inventario();
        Constructor constructor = new Constructor();
        Herramienta herramienta = constructor.crearPicoDeMetal();
        inventario.almacenar(herramienta);
        Herramienta otraHerramienta = constructor.crearPicoDeMetal();
        assertEquals(herramienta, inventario.obtener(otraHerramienta));
    }


    @Test
    public void guardarMaterialEnInventarioSeGuardaCorrectamente(){
        inventario = new Inventario();
        Piedra piedra = new Piedra();
        Piedra otraPiedra = new Piedra();
        inventario.almacenar(piedra);
        assertEquals(piedra, otraPiedra);
    }


    @Test
    public void guardarVariosMaterialesSeGuardanCorrectamente(){
        inventario = new Inventario();
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
        inventario = new Inventario();
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

