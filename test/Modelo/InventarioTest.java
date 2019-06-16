package Modelo;

import org.junit.Test;

import static org.junit.Assert.*;

public class InventarioTest {
    private Inventario inventario;
    private int ancho = 9;
    private int alto = 3;

    @Test
    public void inventarioSeInicializaConPosicionesVaciasTest(){
        inventario = new Inventario();
        for(int x=0; x<ancho; x++){
            for(int y=0; y<alto; y++){
                assertNull(inventario.obtenerDePosicion(x,y));
            }
        }
    }
    @Test
    public void guardarHerramientaEnInventarioSeGuardaEnPrimeraPosicionTest(){
        inventario = new Inventario();
        Constructor constructor = new Constructor();
        Herramienta herramienta = constructor.crearPicoDeMetal();
        inventario.almacenar(herramienta);
        assertEquals(inventario.obtenerDePosicion(0,0), herramienta);
    }

    @Test
    public void guardarMaterialEnInventarioSeGuardaEnPrimeraPosicionTest(){
        inventario = new Inventario();
        Piedra piedra = new Piedra();
        inventario.almacenar(piedra);
        assertEquals(piedra, inventario.obtenerDePosicion(0,0));
    }


    @Test
    public void guardarMaterialesSeAlmacenanLinealmenteEnOrden(){
        inventario = new Inventario();
        Piedra piedra = new Piedra();
        Madera madera = new Madera();
        Diamante diamante = new Diamante();
        Metal metal = new Metal();
        inventario.almacenar(piedra);
        inventario.almacenar(madera);
        inventario.almacenar(diamante);
        inventario.almacenar(metal);
        assertEquals(piedra, inventario.obtenerDePosicion(0,0));
        assertEquals(madera, inventario.obtenerDePosicion(1,0));
        assertEquals(diamante, inventario.obtenerDePosicion(2,0));
        assertEquals(metal, inventario.obtenerDePosicion(3,0));
    }

    @Test
    public void guardarSegundoMaterialNoPisaAlPrimeroTest(){
        inventario = new Inventario();
        Piedra piedra = new Piedra();
        Madera madera = new Madera();
        inventario.almacenar(piedra);
        inventario.almacenar(madera);
        assertEquals(inventario.obtenerDePosicion(0,0), piedra);
    }

}

