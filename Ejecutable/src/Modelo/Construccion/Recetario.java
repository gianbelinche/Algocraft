package Modelo.Construccion;

import Modelo.Herramientas.Herramienta;
import Modelo.Inventario.Inventario;
import Modelo.Materiales.Madera;
import Modelo.Materiales.Metal;
import Modelo.Materiales.Piedra;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Recetario {
    private Map<Receta,Method> recetario;
    private Modelo.Construccion.Constructor constructor;
    private Inventario inventario;

    public Recetario(){
        recetario = new HashMap<>();
        constructor  = new Modelo.Construccion.Constructor();
        inventario = new Inventario();
        crearSemillas();
    }

    public Herramienta craftear(Receta receta){
        Object herramienta = null;

        if (!recetario.containsKey(receta)) {
            return null;
        }

        try {
            herramienta = (recetario.get(receta)).invoke(constructor);
            receta.vaciar();
        }
        catch (IllegalAccessException e) {}
        catch (InvocationTargetException e) { }

        return (Herramienta) herramienta;

    }
    private Method crearMetodo(String unMetodo){
        Method metodo = null;

        try {
            metodo = Constructor.class.getDeclaredMethod(unMetodo);
        } catch (NoSuchMethodException e) { }

        return metodo;
    }

    private void crearSemillaHachaDeMadera(){
        Method metodo = crearMetodo("crearHachaDeMadera");
        Receta recetaHachaDeMadera = new Receta(inventario);
        Madera madera = new Madera();
        inventario.almacenar(new Madera());
        inventario.almacenar(new Madera());
        inventario.almacenar(new Madera());
        inventario.almacenar(new Madera());
        inventario.almacenar(new Madera());
        recetaHachaDeMadera.posicionar(0,0,madera);
        recetaHachaDeMadera.posicionar(0,1,madera);
        recetaHachaDeMadera.posicionar(1,0,madera);
        recetaHachaDeMadera.posicionar(1,1,madera);
        recetaHachaDeMadera.posicionar(2,1,madera);

        recetario.put(recetaHachaDeMadera,metodo);
    }

    private void crearSemillaHachaDePiedra(){
        Method metodo = crearMetodo("crearHachaDePiedra");

        Receta recetaHachaDePiedra = new Receta(inventario);
        Madera madera = new Madera();
        Piedra piedra = new Piedra();
        inventario.almacenar(new Madera());
        inventario.almacenar(new Madera());
        inventario.almacenar(new Piedra());
        inventario.almacenar(new Piedra());
        inventario.almacenar(new Piedra());
        recetaHachaDePiedra.posicionar(0,0,piedra);
        recetaHachaDePiedra.posicionar(0,1,piedra);
        recetaHachaDePiedra.posicionar(1,0,piedra);
        recetaHachaDePiedra.posicionar(1,1,madera);
        recetaHachaDePiedra.posicionar(2,1,madera);

        recetario.put(recetaHachaDePiedra,metodo);
    }

    private void crearSemillaHachaDeMetal(){
        Method metodo = crearMetodo("crearHachaDeMetal");

        Receta recetaHachaDeMetal = new Receta(inventario);
        Madera madera = new Madera();
        Metal metal = new Metal();
        inventario.almacenar(new Metal());
        inventario.almacenar(new Metal());
        inventario.almacenar(new Metal());
        inventario.almacenar(new Madera());
        inventario.almacenar(new Madera());
        recetaHachaDeMetal.posicionar(0,0,metal);
        recetaHachaDeMetal.posicionar(0,1,metal);
        recetaHachaDeMetal.posicionar(1,0,metal);
        recetaHachaDeMetal.posicionar(1,1,madera);
        recetaHachaDeMetal.posicionar(2,1,madera);

        recetario.put(recetaHachaDeMetal,metodo);
    }

    private void crearSemillaPicoDeMadera(){
        Method metodo = crearMetodo("crearPicoDeMadera");
        Receta recetaPicoDeMadera = new Receta(inventario);
        Madera madera = new Madera();
        inventario.almacenar(new Madera());
        inventario.almacenar(new Madera());
        inventario.almacenar(new Madera());
        inventario.almacenar(new Madera());
        inventario.almacenar(new Madera());
        recetaPicoDeMadera.posicionar(0,0,madera);
        recetaPicoDeMadera.posicionar(0,1,madera);
        recetaPicoDeMadera.posicionar(0,2,madera);
        recetaPicoDeMadera.posicionar(1,1,madera);
        recetaPicoDeMadera.posicionar(2,1,madera);

        recetario.put(recetaPicoDeMadera,metodo);
    }

    private void crearSemillaPicoDePiedra(){
        Method metodo = crearMetodo("crearPicoDePiedra");

        Receta recetaPicoDePiedra = new Receta(inventario);
        Madera madera = new Madera();
        Piedra piedra = new Piedra();
        inventario.almacenar(new Madera());
        inventario.almacenar(new Madera());
        inventario.almacenar(new Piedra());
        inventario.almacenar(new Piedra());
        inventario.almacenar(new Piedra());
        recetaPicoDePiedra.posicionar(0,0,piedra);
        recetaPicoDePiedra.posicionar(0,1,piedra);
        recetaPicoDePiedra.posicionar(0,2,piedra);
        recetaPicoDePiedra.posicionar(1,1,madera);
        recetaPicoDePiedra.posicionar(2,1,madera);

        recetario.put(recetaPicoDePiedra,metodo);
    }

    private void crearSemillaPicoDeMetal(){
        Method metodo = crearMetodo("crearPicoDeMetal");

        Receta recetaPicoDeMetal = new Receta(inventario);
        Madera madera = new Madera();
        Metal metal = new Metal();
        inventario.almacenar(new Madera());
        inventario.almacenar(new Madera());
        inventario.almacenar(new Metal());
        inventario.almacenar(new Metal());
        inventario.almacenar(new Metal());
        recetaPicoDeMetal.posicionar(0,0,metal);
        recetaPicoDeMetal.posicionar(0,1,metal);
        recetaPicoDeMetal.posicionar(0,2,metal);
        recetaPicoDeMetal.posicionar(1,1,madera);
        recetaPicoDeMetal.posicionar(2,1,madera);

        recetario.put(recetaPicoDeMetal,metodo);
    }

    private void crearSemillaPicoDePiedraRefinada(){
        Method metodo = crearMetodo("crearPicoDePiedraRefinada");

        Receta recetaPicoDePiedraRefinada = new Receta(inventario);
        Madera madera = new Madera();
        Metal metal = new Metal();
        Piedra piedra = new Piedra();
        inventario.almacenar(new Metal());
        inventario.almacenar(new Metal());
        inventario.almacenar(new Metal());
        inventario.almacenar(new Madera());
        inventario.almacenar(new Madera());
        inventario.almacenar(new Piedra());
        recetaPicoDePiedraRefinada.posicionar(0,0,metal);
        recetaPicoDePiedraRefinada.posicionar(0,1,metal);
        recetaPicoDePiedraRefinada.posicionar(0,2,metal);
        recetaPicoDePiedraRefinada.posicionar(1,0,piedra);
        recetaPicoDePiedraRefinada.posicionar(1,1,madera);
        recetaPicoDePiedraRefinada.posicionar(2,1,madera);

        recetario.put(recetaPicoDePiedraRefinada,metodo);
    }

    private void crearSemillas(){

        this.crearSemillaHachaDeMadera();

        this.crearSemillaHachaDePiedra();

        this.crearSemillaHachaDeMetal();

        this.crearSemillaPicoDeMadera();

        this.crearSemillaPicoDePiedra();

        this.crearSemillaPicoDeMetal();

        this.crearSemillaPicoDePiedraRefinada();

    }
}
