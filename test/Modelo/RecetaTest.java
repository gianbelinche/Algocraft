package Modelo;

import org.junit.Test;

import static org.junit.Assert.*;

public class RecetaTest {

    @Test
    public void testCorrectaInicializacionDeMesaDeCrafteo(){
        Receta receta = new Receta();

        assertNull(receta.enPosicion(0,0));
    }

    @Test
    public void testCorrectoPosicionamientoDeMaterialEnLaPosicion00(){
        Receta receta = new Receta();
        Madera madera = new Madera();
        receta.posicionar(0,0,madera);
        assertEquals(madera,receta.enPosicion(0,0));
    }

    @Test
    public void testCorrectoPosicionamientoDeMaterialEnLaPosicion01(){
        Receta receta = new Receta();
        Madera madera = new Madera();
        receta.posicionar(0,1,madera);
        assertEquals(madera,receta.enPosicion(0,1));
    }

    @Test
    public void testCorrectoPosicionamientoDeMaterialEnLaPosicion02(){
        Receta receta = new Receta();
        Piedra piedra = new Piedra();
        receta.posicionar(0,2,piedra);
        assertEquals(piedra,receta.enPosicion(0,2));
    }

    @Test
    public void testCorrectoPosicionamientoDeMaterialEnLaPosicion10(){
        Receta receta = new Receta();
        Piedra piedra = new Piedra();
        receta.posicionar(1,0,piedra);
        assertEquals(piedra,receta.enPosicion(1,0));
    }

    @Test
    public void testCorrectoPosicionamientoDeMaterialEnLaPosicion11(){
        Receta receta = new Receta();
        Madera madera = new Madera();
        receta.posicionar(1,1,madera);
        assertEquals(madera,receta.enPosicion(1,1));
    }

    @Test
    public void testCorrectoPosicionamientoDeMaterialEnLaPosicion12(){
        Receta receta = new Receta();
        Metal metal = new Metal();
        receta.posicionar(1,2,metal);
        assertEquals(metal,receta.enPosicion(1,2));
    }

    @Test
    public void testCorrectoPosicionamientoDeMaterialEnLaPosicion20(){
        Receta receta = new Receta();
        Madera madera = new Madera();
        receta.posicionar(2,0,madera);
        assertEquals(madera,receta.enPosicion(2,0));
    }

    @Test
    public void testCorrectoPosicionamientoDeMaterialEnLaPosicion21(){
        Receta receta = new Receta();
        Metal metal = new Metal();
        receta.posicionar(2,1,metal);
        assertEquals(metal,receta.enPosicion(2,1));
    }

    @Test
    public void testCorrectoPosicionamientoDeMaterialEnLaPosicion22(){
        Receta receta = new Receta();
        Madera madera = new Madera();
        receta.posicionar(2,2,madera);
        assertEquals(madera,receta.enPosicion(2,2));
    }

    @Test
    public void testDosMesasDeCrafteoVaciasSonIguales(){
        Receta receta1 = new Receta();
        Receta receta2 = new Receta();
        assert(receta1.equals(receta2));
    }

    @Test
    public void testDosMesasConMaderaEnLaPrimerPosicionSonIguales(){
        Receta receta1 = new Receta();
        Receta receta2 = new Receta();
        Madera madera1 = new Madera();
        Madera madera2 = new Madera();
        receta1.posicionar(0,0,madera1);
        receta2.posicionar(0,0,madera2);
        assert(receta1.equals(receta2));
    }


}
