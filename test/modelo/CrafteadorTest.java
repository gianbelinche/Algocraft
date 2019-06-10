package Modelo;

import org.junit.Test;
import static org.junit.Assert.*;

public class CrafteadorTest {

    @Test
    public void testCorrectoCrafteoDeHachaDeMadera(){
        MesaDeCrafteo mesa = new MesaDeCrafteo();
        Madera madera1 = new Madera();
        mesa.posicionar(0,0,madera1);
        Madera madera2 = new Madera();
        mesa.posicionar(0,1,madera2);
        Madera madera3 = new Madera();
        mesa.posicionar(1,0,madera3);
        Madera madera4 = new Madera();
        mesa.posicionar(1,1,madera4);
        Madera madera5 = new Madera();
        mesa.posicionar(2,1,madera5);

        Crafteador crafteador = new Crafteador();

        Herramienta hacha = crafteador.craftear(mesa);
        int fuerzaDelHacha = 2;
        int fuerza = hacha.fuerza();
        assertEquals(fuerzaDelHacha,fuerza);

    }
}
