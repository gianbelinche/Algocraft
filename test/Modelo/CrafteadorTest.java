package Modelo;

import org.junit.Test;
import static org.junit.Assert.*;

public class CrafteadorTest {

    @Test
    public void testCorrectoCrafteoDeHachaDeMadera(){

        MesaDeCrafteo mesa = new MesaDeCrafteo();
        Madera madera = new Madera();
        mesa.posicionar(0,0,madera);
        mesa.posicionar(0,1,madera);
        mesa.posicionar(1,0,madera);
        mesa.posicionar(1,1,madera);
        mesa.posicionar(2,1,madera);

        Crafteador crafteador = new Crafteador();

        Herramienta hacha = crafteador.craftear(mesa);
        int fuerzaDelHacha = 2;
        int fuerza = hacha.fuerza();
        assertEquals(fuerzaDelHacha,fuerza);

    }

    @Test
    public void testCorrectoCrafteoDeHachaDePiedra(){

        MesaDeCrafteo mesa = new MesaDeCrafteo();
        Madera madera = new Madera();
        Piedra piedra = new Piedra();
        mesa.posicionar(0,0,piedra);
        mesa.posicionar(0,1,piedra);
        mesa.posicionar(1,0,piedra);
        mesa.posicionar(1,1,madera);
        mesa.posicionar(2,1,madera);

        Crafteador crafteador = new Crafteador();

        Herramienta hacha = crafteador.craftear(mesa);
        int fuerzaDelHacha = 5;
        int fuerza = hacha.fuerza();
        assertEquals(fuerzaDelHacha,fuerza);

    }

    @Test
    public void testCorrectoCrafteoDeHachaDeMetal(){

        MesaDeCrafteo mesa = new MesaDeCrafteo();
        Madera madera = new Madera();
        Metal metal = new Metal();
        mesa.posicionar(0,0,metal);
        mesa.posicionar(0,1,metal);
        mesa.posicionar(1,0,metal);
        mesa.posicionar(1,1,madera);
        mesa.posicionar(2,1,madera);

        Crafteador crafteador = new Crafteador();

        Herramienta hacha = crafteador.craftear(mesa);
        int fuerzaDelHacha = 10;
        int fuerza = hacha.fuerza();
        assertEquals(fuerzaDelHacha,fuerza);

    }
}
