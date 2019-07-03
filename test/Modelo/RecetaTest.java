package Modelo;

import Modelo.Construccion.Receta;
import Modelo.Inventario.Inventario;
import Modelo.Materiales.Madera;
import Modelo.Materiales.Metal;
import Modelo.Materiales.Piedra;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecetaTest {

    private Receta receta;

    private Inventario inicializarInventario(){
        int numeroCadaMaterial = 10;
        Inventario inventario = new Inventario();
        for(int i = 0; i < numeroCadaMaterial; i++){
            inventario.almacenar(new Madera());
            inventario.almacenar(new Metal());
            inventario.almacenar(new Piedra());
        }
        return inventario;

    }

    @Before
    public void SetUp(){
        Inventario inventario = inicializarInventario();
        receta = new Receta(inventario);

    }

    @Test
    public void testCorrectaInicializacionDeMesaDeCrafteo(){

        assertNull(receta.enPosicion(0,0));
    }

    @Test
    public void testCorrectoPosicionamientoDeMaterialEnLaPosicion00(){
        Madera madera = new Madera();
        receta.posicionar(0,0,madera);
        assertEquals(madera,receta.enPosicion(0,0));
    }

    @Test
    public void testCorrectoPosicionamientoDeMaterialEnLaPosicion01(){
        Madera madera = new Madera();
        receta.posicionar(0,1,madera);
        assertEquals(madera,receta.enPosicion(0,1));
    }

    @Test
    public void testCorrectoPosicionamientoDeMaterialEnLaPosicion02(){
        Piedra piedra = new Piedra();
        receta.posicionar(0,2,piedra);
        assertEquals(piedra,receta.enPosicion(0,2));
    }

    @Test
    public void testCorrectoPosicionamientoDeMaterialEnLaPosicion10(){
        Piedra piedra = new Piedra();
        receta.posicionar(1,0,piedra);
        assertEquals(piedra,receta.enPosicion(1,0));
    }

    @Test
    public void testCorrectoPosicionamientoDeMaterialEnLaPosicion11(){
        Madera madera = new Madera();
        receta.posicionar(1,1,madera);
        assertEquals(madera,receta.enPosicion(1,1));
    }

    @Test
    public void testCorrectoPosicionamientoDeMaterialEnLaPosicion12(){
        Metal metal = new Metal();
        receta.posicionar(1,2,metal);
        assertEquals(metal,receta.enPosicion(1,2));
    }

    @Test
    public void testCorrectoPosicionamientoDeMaterialEnLaPosicion20(){
        Madera madera = new Madera();
        receta.posicionar(2,0,madera);
        assertEquals(madera,receta.enPosicion(2,0));
    }

    @Test
    public void testCorrectoPosicionamientoDeMaterialEnLaPosicion21(){
        Metal metal = new Metal();
        receta.posicionar(2,1,metal);
        assertEquals(metal,receta.enPosicion(2,1));
    }

    @Test
    public void testCorrectoPosicionamientoDeMaterialEnLaPosicion22(){
        Madera madera = new Madera();
        receta.posicionar(2,2,madera);
        assertEquals(madera,receta.enPosicion(2,2));
    }

    @Test
    public void testDosMesasDeCrafteoVaciasSonIguales(){
        Inventario inventario1 = new Inventario();
        Inventario inventario2 = new Inventario();
        Receta receta1 = new Receta(inventario1);
        Receta receta2 = new Receta(inventario2);
        assert(receta1.equals(receta2));
    }

    @Test
    public void testDosMesasConMaderaEnLaPrimerPosicionSonIguales(){
        Inventario inventario1 = new Inventario();
        inventario1.almacenar(new Madera());
        Inventario inventario2 = new Inventario();
        inventario2.almacenar(new Madera());

        Receta receta1 = new Receta(inventario1);
        Receta receta2 = new Receta(inventario2);
        Madera madera1 = new Madera();
        Madera madera2 = new Madera();
        receta1.posicionar(0,0,madera1);
        receta2.posicionar(0,0,madera2);
        assert(receta1.equals(receta2));
    }


}
