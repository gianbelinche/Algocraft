package Modelo;

import Modelo.Construccion.Receta;
import Modelo.Construccion.Recetario;
import Modelo.Herramientas.Herramienta;
import Modelo.Inventario.Inventario;
import Modelo.Materiales.Diamante;
import Modelo.Materiales.Madera;
import Modelo.Materiales.Metal;
import Modelo.Materiales.Piedra;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RecetarioTest {

    private Receta receta;

    private Inventario inicializarInventario(){
            int numeroCadaMaterial = 30;
            Inventario inventario = new Inventario();
            for(int i = 0; i < numeroCadaMaterial; i++){
                inventario.almacenar(new Madera());
                inventario.almacenar(new Metal());
                inventario.almacenar(new Piedra());
                inventario.almacenar(new Diamante());
            }
            return inventario;

    }

    @Before
    public void SetUp(){
        Inventario inventario = inicializarInventario();
        receta = new Receta(inventario);

    }

    @Test
    public void testCorrectoCrafteoDeHachaDeMadera(){

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
