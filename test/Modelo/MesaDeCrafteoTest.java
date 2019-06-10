package Modelo;

import org.junit.Test;

import java.util.Objects;

import static org.junit.Assert.*;

public class MesaDeCrafteoTest {

    @Test
    public void testCorrectaInicializacionDeMesaDeCrafteo(){
        MesaDeCrafteo mesa = new MesaDeCrafteo();

        assertNull(mesa.enPosicion(0,0));
    }

    @Test
    public void testCorrectoPosicionamientoDeMaterialEnLaPosicion00(){
        MesaDeCrafteo mesa = new MesaDeCrafteo();
        Madera madera = new Madera();
        mesa.posicionar(0,0,madera);
        assertEquals(madera,mesa.enPosicion(0,0));
    }

    @Test
    public void testCorrectoPosicionamientoDeMaterialEnLaPosicion01(){
        MesaDeCrafteo mesa = new MesaDeCrafteo();
        Madera madera = new Madera();
        mesa.posicionar(0,1,madera);
        assertEquals(madera,mesa.enPosicion(0,1));
    }

    @Test
    public void testCorrectoPosicionamientoDeMaterialEnLaPosicion02(){
        MesaDeCrafteo mesa = new MesaDeCrafteo();
        Piedra piedra = new Piedra();
        mesa.posicionar(0,2,piedra);
        assertEquals(piedra,mesa.enPosicion(0,2));
    }

    @Test
    public void testCorrectoPosicionamientoDeMaterialEnLaPosicion10(){
        MesaDeCrafteo mesa = new MesaDeCrafteo();
        Piedra piedra = new Piedra();
        mesa.posicionar(1,0,piedra);
        assertEquals(piedra,mesa.enPosicion(1,0));
    }

    @Test
    public void testCorrectoPosicionamientoDeMaterialEnLaPosicion11(){
        MesaDeCrafteo mesa = new MesaDeCrafteo();
        Madera madera = new Madera();
        mesa.posicionar(1,1,madera);
        assertEquals(madera,mesa.enPosicion(1,1));
    }

    @Test
    public void testCorrectoPosicionamientoDeMaterialEnLaPosicion12(){
        MesaDeCrafteo mesa = new MesaDeCrafteo();
        Metal metal = new Metal();
        mesa.posicionar(1,2,metal);
        assertEquals(metal,mesa.enPosicion(1,2));
    }

    @Test
    public void testCorrectoPosicionamientoDeMaterialEnLaPosicion20(){
        MesaDeCrafteo mesa = new MesaDeCrafteo();
        Madera madera = new Madera();
        mesa.posicionar(2,0,madera);
        assertEquals(madera,mesa.enPosicion(2,0));
    }

    @Test
    public void testCorrectoPosicionamientoDeMaterialEnLaPosicion21(){
        MesaDeCrafteo mesa = new MesaDeCrafteo();
        Metal metal = new Metal();
        mesa.posicionar(2,1,metal);
        assertEquals(metal,mesa.enPosicion(2,1));
    }

    @Test
    public void testCorrectoPosicionamientoDeMaterialEnLaPosicion22(){
        MesaDeCrafteo mesa = new MesaDeCrafteo();
        Madera madera = new Madera();
        mesa.posicionar(2,2,madera);
        assertEquals(madera,mesa.enPosicion(2,2));
    }

    @Test
    public void testDosMesasDeCrafteoVaciasSonIguales(){
        MesaDeCrafteo mesa1 = new MesaDeCrafteo();
        MesaDeCrafteo mesa2 = new MesaDeCrafteo();
        assert(mesa1.equals(mesa2));
    }

    @Test
    public void testDosMesasConMaderaEnLaPrimerPosicionSonIguales(){
        MesaDeCrafteo mesa1 = new MesaDeCrafteo();
        MesaDeCrafteo mesa2 = new MesaDeCrafteo();
        Madera madera1 = new Madera();
        Madera madera2 = new Madera();
        mesa1.posicionar(0,0,madera1);
        mesa2.posicionar(0,0,madera2);
        assert(mesa1.equals(mesa2));
    }


}
