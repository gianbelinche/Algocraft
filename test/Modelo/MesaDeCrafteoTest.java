package Modelo;

import org.junit.Test;
import static org.junit.Assert.*;

public class MesaDeCrafteoTest {

    @Test
    public void testCorrectaInicializacionDeMesaDeCrafteo(){
        MesaDeCrafteo mesa = new MesaDeCrafteo();
        Material [][] semilla = mesa.obtenerSemilla();
        assertEquals(null,semilla[0][0]);
    }

    @Test
    public void testCorrectoPosicionamientoDeMaterialEnLaPosicion00(){
        MesaDeCrafteo mesa = new MesaDeCrafteo();
        Madera madera = new Madera();
        mesa.posicionar(0,0,madera);
        Material [][] semilla = mesa.obtenerSemilla();
        assertEquals(madera,semilla[0][0]);
    }
}
