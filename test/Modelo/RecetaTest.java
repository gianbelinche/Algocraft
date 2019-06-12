package Modelo;

import org.junit.Test;

import static org.junit.Assert.*;

public class RecetaTest {

    @Test
    public void testCorrectaInicializacionDeMesaDeCrafteo(){
        Receta mesa = new Receta();

        assertNull(mesa.enPosicion(0,0));
    }

    @Test
    public void testCorrectoPosicionamientoDeMaterialEnLaPosicion00(){
        Receta mesa = new Receta();
        Madera madera = new Madera();
        mesa.posicionar(0,0,madera);
        assertEquals(madera,mesa.enPosicion(0,0));
    }

    @Test
    public void testCorrectoPosicionamientoDeMaterialEnLaPosicion01(){
        Receta mesa = new Receta();
        Madera madera = new Madera();
        mesa.posicionar(0,1,madera);
        assertEquals(madera,mesa.enPosicion(0,1));
    }

    @Test
    public void testCorrectoPosicionamientoDeMaterialEnLaPosicion02(){
        Receta mesa = new Receta();
        Piedra piedra = new Piedra();
        mesa.posicionar(0,2,piedra);
        assertEquals(piedra,mesa.enPosicion(0,2));
    }

    @Test
    public void testCorrectoPosicionamientoDeMaterialEnLaPosicion10(){
        Receta mesa = new Receta();
        Piedra piedra = new Piedra();
        mesa.posicionar(1,0,piedra);
        assertEquals(piedra,mesa.enPosicion(1,0));
    }

    @Test
    public void testCorrectoPosicionamientoDeMaterialEnLaPosicion11(){
        Receta mesa = new Receta();
        Madera madera = new Madera();
        mesa.posicionar(1,1,madera);
        assertEquals(madera,mesa.enPosicion(1,1));
    }

    @Test
    public void testCorrectoPosicionamientoDeMaterialEnLaPosicion12(){
        Receta mesa = new Receta();
        Metal metal = new Metal();
        mesa.posicionar(1,2,metal);
        assertEquals(metal,mesa.enPosicion(1,2));
    }

    @Test
    public void testCorrectoPosicionamientoDeMaterialEnLaPosicion20(){
        Receta mesa = new Receta();
        Madera madera = new Madera();
        mesa.posicionar(2,0,madera);
        assertEquals(madera,mesa.enPosicion(2,0));
    }

    @Test
    public void testCorrectoPosicionamientoDeMaterialEnLaPosicion21(){
        Receta mesa = new Receta();
        Metal metal = new Metal();
        mesa.posicionar(2,1,metal);
        assertEquals(metal,mesa.enPosicion(2,1));
    }

    @Test
    public void testCorrectoPosicionamientoDeMaterialEnLaPosicion22(){
        Receta mesa = new Receta();
        Madera madera = new Madera();
        mesa.posicionar(2,2,madera);
        assertEquals(madera,mesa.enPosicion(2,2));
    }

    @Test
    public void testDosMesasDeCrafteoVaciasSonIguales(){
        Receta mesa1 = new Receta();
        Receta mesa2 = new Receta();
        assert(mesa1.equals(mesa2));
    }

    @Test
    public void testDosMesasConMaderaEnLaPrimerPosicionSonIguales(){
        Receta mesa1 = new Receta();
        Receta mesa2 = new Receta();
        Madera madera1 = new Madera();
        Madera madera2 = new Madera();
        mesa1.posicionar(0,0,madera1);
        mesa2.posicionar(0,0,madera2);
        assert(mesa1.equals(mesa2));
    }


}
