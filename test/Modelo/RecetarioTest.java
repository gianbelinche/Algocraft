package Modelo;

import Modelo.Construccion.Receta;
import Modelo.Construccion.Recetario;
import Modelo.Herramientas.Herramienta;
import Modelo.Materiales.Madera;
import Modelo.Materiales.Metal;
import Modelo.Materiales.Piedra;
import org.junit.Test;
import static org.junit.Assert.*;

public class RecetarioTest {

    @Test
    public void testCorrectoCrafteoDeHachaDeMadera(){

        Receta receta = new Receta();
        Madera madera = new Madera();
        receta.posicionar(0,0,madera);
        receta.posicionar(0,1,madera);
        receta.posicionar(1,0,madera);
        receta.posicionar(1,1,madera);
        receta.posicionar(2,1,madera);

        Recetario recetario = new Recetario();

        Herramienta hacha = recetario.craftear(receta);
        int fuerzaDelHacha = 2;
        int fuerza = hacha.fuerza();
        assertEquals(fuerzaDelHacha,fuerza);

    }

    @Test
    public void testCorrectoCrafteoDeHachaDePiedra(){

        Receta receta = new Receta();
        Madera madera = new Madera();
        Piedra piedra = new Piedra();
        receta.posicionar(0,0,piedra);
        receta.posicionar(0,1,piedra);
        receta.posicionar(1,0,piedra);
        receta.posicionar(1,1,madera);
        receta.posicionar(2,1,madera);

        Recetario recetario = new Recetario();

        Herramienta hacha = recetario.craftear(receta);
        int fuerzaDelHacha = 5;
        int fuerza = hacha.fuerza();
        assertEquals(fuerzaDelHacha,fuerza);

    }

    @Test
    public void testCorrectoCrafteoDeHachaDeMetal(){

        Receta receta = new Receta();
        Madera madera = new Madera();
        Metal metal = new Metal();
        receta.posicionar(0,0,metal);
        receta.posicionar(0,1,metal);
        receta.posicionar(1,0,metal);
        receta.posicionar(1,1,madera);
        receta.posicionar(2,1,madera);

        Recetario recetario = new Recetario();

        Herramienta hacha = recetario.craftear(receta);
        int fuerzaDelHacha = 10;
        int fuerza = hacha.fuerza();
        assertEquals(fuerzaDelHacha,fuerza);

    }

    @Test
    public void testCorrectoCrafteoDePicoDeMadera(){

        Receta receta = new Receta();
        Madera madera = new Madera();
        receta.posicionar(0,0,madera);
        receta.posicionar(0,1,madera);
        receta.posicionar(0,2,madera);
        receta.posicionar(1,1,madera);
        receta.posicionar(2,1,madera);

        Recetario recetario = new Recetario();

        Herramienta pico = recetario.craftear(receta);
        int fuerzaDelPico = 2;
        int fuerza = pico.fuerza();
        assertEquals(fuerzaDelPico,fuerza);

    }

    @Test
    public void testCorrectoCrafteoDePicoDePiedra(){

        Receta receta = new Receta();
        Madera madera = new Madera();
        Piedra piedra = new Piedra();
        receta.posicionar(0,0,piedra);
        receta.posicionar(0,1,piedra);
        receta.posicionar(0,2,piedra);
        receta.posicionar(1,1,madera);
        receta.posicionar(2,1,madera);

        Recetario recetario = new Recetario();

        Herramienta pico = recetario.craftear(receta);
        int fuerzaDelPico = 4;
        int fuerza = pico.fuerza();
        assertEquals(fuerzaDelPico,fuerza);

    }

    @Test
    public void testCorrectoCrafteoDePicoDeMetal(){

        Receta receta = new Receta();
        Madera madera = new Madera();
        Metal metal = new Metal();
        receta.posicionar(0,0,metal);
        receta.posicionar(0,1,metal);
        receta.posicionar(0,2,metal);
        receta.posicionar(1,1,madera);
        receta.posicionar(2,1,madera);

        Recetario recetario = new Recetario();

        Herramienta pico = recetario.craftear(receta);
        int fuerzaDelPico = 12;
        int fuerza = pico.fuerza();
        assertEquals(fuerzaDelPico,fuerza);

    }

    @Test
    public void testCorrectoCrafteoDePicoDePiedraRefinada(){

        Receta receta = new Receta();
        Madera madera = new Madera();
        Piedra piedra = new Piedra();
        Metal metal = new Metal();
        receta.posicionar(0,0,metal);
        receta.posicionar(0,1,metal);
        receta.posicionar(0,2,metal);
        receta.posicionar(1,0,piedra);
        receta.posicionar(1,1,madera);
        receta.posicionar(2,1,madera);

        Recetario recetario = new Recetario();

        Herramienta pico = recetario.craftear(receta);
        int fuerzaDelPico = 20;
        int fuerza = pico.fuerza();
        assertEquals(fuerzaDelPico,fuerza);

    }

}
